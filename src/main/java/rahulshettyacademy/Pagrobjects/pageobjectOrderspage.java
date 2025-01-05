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

public class pageobjectOrderspage extends Abstractcomponents{
	WebDriver driver;
	
	public pageobjectOrderspage(WebDriver driver) {
		super(driver);//to import parent class
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//xpath //tbody/tr[1]/td[2]")
	WebElement firstorderinlist;
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderslistelement;
	
	public Boolean  ordersinlist(String prod1name) {
		
		Boolean ordermatch= orderslistelement.stream().anyMatch(p->p.getText().equalsIgnoreCase(prod1name));
		
		
       return ordermatch;
	}
	
}
