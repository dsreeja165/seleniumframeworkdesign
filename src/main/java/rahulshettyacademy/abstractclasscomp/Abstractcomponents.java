package rahulshettyacademy.abstractclasscomp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.Pagrobjects.pageobjectOrderspage;

public class Abstractcomponents {

	WebDriver driver;
	
	public Abstractcomponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderspage;
	public void waituntilelementdisappear(By findBy) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));   //By.cssSelector("#toast-container")
	}
	public void waituntilelementappear(By findBy) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));   //By.cssSelector("#toast-container")
	}
	public void waituntilelementappear(WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element)); 
	}
	public void waituntilelementdisappear(WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));   //By.cssSelector("#toast-container")
	}
	public void waitallelementsappear(List<WebElement> list) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElements(list));  //By.xpath("//section/button[@type='button']")
	}
	public pageobjectOrderspage gotoOrders() {
		pageobjectOrderspage orderpage1= new pageobjectOrderspage(driver);
		orderspage.click();
		return orderpage1;
	}

}
