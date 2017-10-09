package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import enums.FileExtensions;
import factories.DriverFactory;

public class ReportHelper {
	private ExtentReports report;
	private ExtentTest test;
	private String reportFile ="";
	
	public ReportHelper(String nameOfTestCase) {
		reportFile = createReportFile();
		report = new ExtentReports(reportFile);
		test = report.startTest(nameOfTestCase);
	}
	
	public void log(LogStatus logStatus,String details) {
		test.log(logStatus, details);
	}
	
	public void exportReport(ITestResult result,WebDriver driver) {
		if (result.getStatus()==ITestResult.FAILURE) {
			String failureScreenshot = DriverFactory.takeScreenShot(driver);
			test.log(LogStatus.FAIL,"Test Case Failed",test.addScreenCapture(failureScreenshot));
		}
		 
		report.endTest(test);
		report.flush();
		driver.get(reportFile);
	}
	private String createReportFile() {
		return PathHelper.createFile("reports", FileExtensions.HTML);
	}
	
}
