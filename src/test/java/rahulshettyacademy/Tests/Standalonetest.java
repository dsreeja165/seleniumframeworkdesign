package rahulshettyacademy.Tests;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonetest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String prod1name="ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sreejasria83@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("SRIja@123");
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		List<WebElement> products =driver.findElements(By.xpath("//div[contains(@class,'col-lg-4')]"));
		WebElement Filteredprod = products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(prod1name)).findFirst().orElse(null);
		Filteredprod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating --loading wait
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//click on cart symbol
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='cart']")));
		//div/h3
		List<WebElement> cartprods =driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("C:\\Users\\sreej\\Pictures\\Screenshots\\sourceseleniums\\screenshotRSA1.png"));
		Boolean present= cartprods.stream().anyMatch(p->p.getText().equalsIgnoreCase(prod1name));
		Assert.assertTrue(present);
		
		driver.findElement(By.cssSelector(".totalRow .btn.btn-primary")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
	//WebElement country = driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section/button[@type='button']")));
		
	//	country.sendKeys(Keys.DOWN);
	//	country.sendKeys(Keys.DOWN);
	//	country.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//section/button[@type='button'][2]")).click();
		
		driver.findElement(By.cssSelector(".btnn")).click();
		
		String confirmmsg= driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(	confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	driver.quit();
		
	
		
		////section/button[@type='button']
		
		
	}

}
