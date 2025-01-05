package rahulshettyacademy.Pagrobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractclasscomp.Abstractcomponents;

public class pageobjectlogin extends Abstractcomponents {

	WebDriver driver;
	public pageobjectlogin(WebDriver driver) {
		super(driver);
	this.driver=driver;
	PageFactory.initElements( driver, this);
	}
	
	//pagefactory for login page -->to write webelements we have a design pattern called pagefactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")     // we have written webElements
	WebElement Userpwd;
	@FindBy(id="login")
	WebElement loginbtn;
	@FindBy(css="[Class*='flyInOut']")
	WebElement errormessage;
	By loginsucessmsg = By.cssSelector("#toast-container");
	  
	//login page actions method -->can call in test repositryor test classes
	public pageobjectproductcatalouge loginactions(String email , String password) {
		userEmail.sendKeys(email);    // you should not give sreejasria83@gmail.com becoz this is just elements and actions
		Userpwd.sendKeys(password);
		loginbtn.click();
		waituntilelementdisappear(loginsucessmsg);
		pageobjectproductcatalouge productcatlouge = new pageobjectproductcatalouge(driver);
		return productcatlouge;
	}
	
	//login page url method
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errormsg() {
		waituntilelementappear(errormessage);
		String err= errormessage.getText();
		System.out.println(err);
		return err;
	}
	
	

}
