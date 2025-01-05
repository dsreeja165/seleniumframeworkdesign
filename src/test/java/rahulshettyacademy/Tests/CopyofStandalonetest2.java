package rahulshettyacademy.Tests;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.Pagrobjects.pageobjectOrderspage;
import rahulshettyacademy.Pagrobjects.pageobjectcheckout;
import rahulshettyacademy.Pagrobjects.pageobjectlogin;
import rahulshettyacademy.Pagrobjects.pageobjectproductcatalouge;
import rahulshettyacademy.Pagrobjects.pageobjectscheckoutprocess;
import rahulshettyacademy.Pagrobjects.pageobjectthanks;
import rahulshettyacademy.Testcomponents.Basedrivertest;

public class CopyofStandalonetest2 extends Basedrivertest {
	
	@Test(dataProvider="getData",groups= {"multiplelogs"})
	public void SubmitOrder( HashMap<String, String> input0 )throws IOException {
		// TODO Auto-generated method stubHashMap<String, String> input0
		
		
		
		pageobjectproductcatalouge productcatlouge =loginpageobjects.loginactions(input0.get("email"),input0.get("pwd"));
		//wait for productlist + and retrive into list of productlist
		List<WebElement>products = productcatlouge.getprodlist();
		//from list to product 
		productcatlouge.getproductname(input0.get("prodname"));
		//adding to cart
		pageobjectcheckout pagecheckout = 	productcatlouge.addprodtocart(input0.get("prodname"));
		//checkout cart page
		pagecheckout.checkoutcart();
		//Boolean match = pagecheckout.clickproceedcheckout(prod1name);
		//Assert.assertTrue(match);   //assertions are to be in test reository only
		pageobjectscheckoutprocess finalcheckoutpros = pagecheckout.clickproceedcheckout(input0.get("prodname"));
		//checkoutprocess page
		pageobjectthanks thankspage  = finalcheckoutpros.checkoutprocessmethod(input0.get("countryname"));
		//final assertion
		String getmsg =thankspage.msg();
		//System.out.println(getmsg);
	Assert.assertTrue(	getmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
 //to verify"zara coat 3 is in orders list 
	@Test(dependsOnMethods={"SubmitOrder"},dataProvider= "getData")
	public void ordersHistorypage(HashMap<String, String> input0) throws IOException {
		pageobjectproductcatalouge productcatlouge =loginpageobjects.loginactions(input0.get("email"),input0.get("pwd"));
		pageobjectOrderspage orderspage1 =productcatlouge.gotoOrders();
	Assert.assertTrue(orderspage1.ordersinlist(input0.get("prodname")));
		
		
		
		
	}
	//Giving data provider with hashmap 
	//can provide class attritbute (HashMap<string,string> input);
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data=getjsondata(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//purchaseorder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	/*public Object[][] getData() {
		
		HashMap<Object,Object> map =new HashMap<Object,Object>();
		map.put("email", "sreejasria83@gmail.com");
		map.put("pwd", "SRIja@123");
		map.put("prodname", "ZARA COAT 3");
		map.put("countryname", "ind");
		
		HashMap<Object,Object> map1 =new HashMap<Object,Object>();
		map1.put("email", "rathna@gmail.com");
		map1.put("pwd", "SRIja@123");
		map1.put("prodname", "ZARA COAT 3");
		map1.put("countryname", "ind");
		return new Object[][] {{map},{map1}};
	}
		*/
	//Giving directly within strings
	//in class method arguments we have to give(String email, String pwd, String prodname, String country);
	/*@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"sreejasria83@gmail.com","SRIja@123","ZARA COAT 3","ind"},{"rathna@gmail.com","SRIja@123","ZARA COAT 3","ind"}};
	}*/
		
	
	

}
