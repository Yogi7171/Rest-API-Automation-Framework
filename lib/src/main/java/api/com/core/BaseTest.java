package api.com.core;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.LogStatus;

import api.com.util.ExtentReport;
import api.com.util.Helper;

public class BaseTest {
@BeforeSuite(alwaysRun=true)
	public void config() throws IOException
	{

		String subfolderpath = System.getProperty("user.dir")+"/htmlReports/"+Helper.Timestamp();
		Helper.CreateFolder(subfolderpath);
		ExtentReport.initialize(subfolderpath+"/"+"API_Automation.html");  
	}
@BeforeMethod(alwaysRun=true)
public static void LogBeforeMethod() {
	System.out.println("Test Case Execution Started");
}
@AfterMethod(alwaysRun=true)
public void getResult(ITestResult result) 
{
		if (result.getStatus() == ITestResult.SUCCESS) 
		{	ExtentReport.extentlog.log(LogStatus.PASS, "Test Case : "
				+ ""+ result.getName()+" is passed ");
		} else if (result.getStatus() == ITestResult.FAILURE) 
		{	ExtentReport.extentlog.log(LogStatus.FAIL, "Test case : "
				+ result.getName()+" is failed ");
			ExtentReport.extentlog.log(LogStatus.FAIL, "Test case is failed due to:  "
				+ result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {

		ExtentReport.extentlog.log(LogStatus.SKIP, "Test case is Skiped "
				+ result.getName());
		}
		ExtentReport.extentreport.endTest(ExtentReport.extentlog);
}
@AfterSuite(alwaysRun = true)

public void endReport() {

	//ExtentReport.extentreport.flush();

	ExtentReport.extentreport.flush();

	//Logging.setinstanceNull();

}




}
