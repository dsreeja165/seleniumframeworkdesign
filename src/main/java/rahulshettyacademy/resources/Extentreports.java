package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
 
public static ExtentReports config() {
		
		String file =System.getProperty("user.dir")+"\\reports\\testcase.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		
		
		reporter.config().setReportName("web automation reports");
		reporter.config().setDocumentTitle("TestNG Reposrts");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("tester", "sreeja");
		
		return report;
	}
}
