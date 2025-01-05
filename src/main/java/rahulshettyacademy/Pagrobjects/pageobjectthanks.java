package rahulshettyacademy.Pagrobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractclasscomp.Abstractcomponents;

public class pageobjectthanks extends Abstractcomponents {
	WebDriver driver;
	public pageobjectthanks(WebDriver driver) {
		super(driver);//to import parent class
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement msg;
	@FindBy(css="")
	WebElement logout;
	
	public String msg() {
		String confirmmsg= msg.getText();
		return confirmmsg;
	}
	public void logout() {
		logout.click();
	}
}
