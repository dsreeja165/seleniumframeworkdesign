package rahulshettyacademy.Pagrobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractclasscomp.Abstractcomponents;

public class pageobjectproductcatalouge extends Abstractcomponents{

	WebDriver driver;
	public pageobjectproductcatalouge(WebDriver driver) {
		super(driver);//to import parent class
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	//pagefactory -->to write webelements we have a design pattern called pagefactory
	//list of products in product catalouge  
	@FindBy(xpath="//div[contains(@class,'col-lg-4')]")
	List<WebElement> products;
	By productlist= By.xpath("//div[contains(@class,'col-lg-4')]");   //assigning  locator productlist in below getprodlist method
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By waitformsg = By.cssSelector("#toast-container");
	@FindBy(css=".ng-animating")
	WebElement loadingspin;
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartclick;
	 
	//created method getprodlist to retrive list of webelements
	public List<WebElement> getprodlist() {
		waituntilelementappear(productlist);
		return products;	
	}
	//from list retrieve the required webelement
	public WebElement getproductname(String prodname) {
		WebElement Filteredprod = getprodlist().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(prodname)).findFirst().orElse(null);
		return Filteredprod;
	}
	//adding to cart 
	public pageobjectcheckout addprodtocart(String prodname) {
		WebElement Filteredprod= getproductname(prodname);
	Filteredprod.findElement(addtocart).click();
	waituntilelementappear(waitformsg);    //wait for toasting msg added succesfully
	waituntilelementdisappear(loadingspin);
	cartclick.click(); //click on cart symbol
	pageobjectcheckout pagecheckout =new pageobjectcheckout(driver);
	return pagecheckout;
	}
	
	

}
