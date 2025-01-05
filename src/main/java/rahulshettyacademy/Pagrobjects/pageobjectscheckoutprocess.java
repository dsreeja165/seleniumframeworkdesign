package rahulshettyacademy.Pagrobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractclasscomp.Abstractcomponents;

public class pageobjectscheckoutprocess extends Abstractcomponents {

	WebDriver driver;
	public pageobjectscheckoutprocess(WebDriver driver) {
		super(driver);
	this.driver=driver;
	PageFactory.initElements( driver, this);
	}
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryholder;
	@FindBy(xpath="//section/button[@type='button']")
	List<WebElement> dropdownlist;
	@FindBy(xpath="//section/button[@type='button'][2]")
	WebElement keyboardclick;
	@FindBy(css=".btnn")
	WebElement Finalclick;
	 
	public pageobjectthanks checkoutprocessmethod(String str) {
	countryholder.sendKeys(str);
	waitallelementsappear(dropdownlist);
	keyboardclick.click();
	Finalclick.click();
	pageobjectthanks thankspage  = new pageobjectthanks(driver);
	return thankspage;
	}
	
}
