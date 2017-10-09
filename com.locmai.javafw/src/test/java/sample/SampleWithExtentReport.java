package sample;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import enums.DriverType;
import factories.DriverFactory;
import sample.urls.CustomUrls;
import utilities.ReportHelper;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class SampleWithExtentReport {
	DriverFactory factory = new DriverFactory();
	WebDriver driver = factory.createDriver(DriverType.CHROME);
	ReportHelper report = new ReportHelper("Verify Title");

	@Test
	public void VerifyTitle() {
		report.log(LogStatus.INFO, "Login Page");
		driver.get(CustomUrls.LOGIN.getUrl());
		
		report.log(LogStatus.INFO, "Send Keys");
		WebElement txtUsername = driver.findElement(By.xpath("//input[@name='userName']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@name='password']"));
		txtUsername.sendKeys("demo");
		txtPassword.sendKeys("demo");
		
		report.log(LogStatus.INFO, "Submit Login");
		WebElement btnSubmit = driver.findElement(By.xpath("//input[@name='login']"));
		btnSubmit.click();
		
		report.log(LogStatus.FAIL, "Fail For Sure");
		String expectedTitle = "Sign-on: Mercury Tours";
		assertEquals(driver.getTitle(), expectedTitle);
	}

	@AfterMethod
	public void afterTest(ITestResult result) {
		report.exportReport(result, driver);
	}

}
