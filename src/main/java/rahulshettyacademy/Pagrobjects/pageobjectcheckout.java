package rahulshettyacademy.Pagrobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import rahulshettyacademy.abstractclasscomp.Abstractcomponents;

public class pageobjectcheckout extends Abstractcomponents{
	WebDriver driver;
	public pageobjectcheckout(WebDriver driver) {
		super(driver);//to import parent class
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	By waitforlistincheckout =By.cssSelector("div[class='cart']");
	@FindBy(xpath="//*[@class='cartSection']/h3")
	List<WebElement> cartprods;
	@FindBy(css=".totalRow .btn.btn-primary")
	WebElement checkoutbutton;
	
	
	public List<WebElement> checkoutcart() {
		waituntilelementappear(waitforlistincheckout);
       return cartprods;
	}
	 public pageobjectscheckoutprocess clickproceedcheckout(String prod1name) {
	checkoutcart().stream().anyMatch(p->p.getText().equalsIgnoreCase(prod1name));
	checkoutbutton.click();
	pageobjectscheckoutprocess finalcheckoutpros=new pageobjectscheckoutprocess(driver);
	return finalcheckoutpros;
	 }
}
