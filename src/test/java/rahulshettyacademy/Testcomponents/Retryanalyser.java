package rahulshettyacademy.Testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanalyser implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count =0;
		int Maxtry=1;
		if(count<Maxtry) {
			count++;
			return true;
		}
		
		return false;
	}

}
