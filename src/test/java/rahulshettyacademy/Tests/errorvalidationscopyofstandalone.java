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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.Pagrobjects.pageobjectcheckout;
import rahulshettyacademy.Pagrobjects.pageobjectlogin;
import rahulshettyacademy.Pagrobjects.pageobjectproductcatalouge;
import rahulshettyacademy.Pagrobjects.pageobjectscheckoutprocess;
import rahulshettyacademy.Pagrobjects.pageobjectthanks;
import rahulshettyacademy.Testcomponents.Basedrivertest;
import rahulshettyacademy.Testcomponents.Retryanalyser;

public class errorvalidationscopyofstandalone extends Basedrivertest {

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retryanalyser.class)
	public void CopyofStandalonetest2() throws IOException {
		// TODO Auto-generated method stub
		
		String prod1name="ZARA COAT 3";
		String str ="ind";
		loginpageobjects.loginactions("sreeja@gmail.com", "SRIja@123");
		 loginpageobjects.errormsg();
		Assert.assertEquals("Incorrect email or password." , loginpageobjects.errormsg());
			
	}
	@Test
	public void errorcopyofStandalonetest1() throws IOException {
		// TODO Auto-generated method stub
		
		String prod1name="ZARA COAT 3";
		String str ="ind";
		pageobjectproductcatalouge productcatlouge =loginpageobjects.loginactions("sreejasria83@gmail.com", "SRIja@123");
		List<WebElement>products = productcatlouge.getprodlist();
		productcatlouge.getproductname(prod1name);
		pageobjectcheckout pagecheckout = 	productcatlouge.addprodtocart(prod1name);
		
	}
}
