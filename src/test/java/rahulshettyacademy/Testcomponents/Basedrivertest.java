package rahulshettyacademy.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.Pagrobjects.pageobjectlogin;

public class Basedrivertest {      // just to intialize the browser from properties file(which is in srcmain)
	public WebDriver driver ;
	public pageobjectlogin loginpageobjects;
	
	public WebDriver intializedriver() throws IOException {
		 
		
		//property class -->created in main resources
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//globaldata.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();     
		driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox"))
		{
			//firefox
		}else if (browserName.equalsIgnoreCase("edge"))
		{
			//edgedriver
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	@BeforeMethod(alwaysRun=true)
	public pageobjectlogin launchApplication() throws IOException {
		driver= intializedriver();
		 loginpageobjects = new pageobjectlogin(driver);
		//loginpage -pageobject
		loginpageobjects.goTo();
		return loginpageobjects;
	}
	@AfterMethod(alwaysRun=true)
	public void close() {
	  driver.quit();
	}
	//getjsondata -->data email,pwd are in json format
	public List<HashMap<String, String>> getjsondata(String Filepath) throws IOException {   //json to hashmap ga convert
		//read json to string
		String jsoncontent =FileUtils.readFileToString(new File(Filepath));
		
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>>	data= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	public String getScreenShot(String testCaseName) throws IOException {
		TakesScreenshot ts =(TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports"+ testCaseName +".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir")+"//reports"+ testCaseName +".png";
	}
}
