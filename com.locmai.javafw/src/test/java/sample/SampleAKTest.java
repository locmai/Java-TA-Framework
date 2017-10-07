package sample;

import org.testng.annotations.Test;

import enums.DriverType;
import factories.DriverFactory;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import sample.urls.CustomUrls;

public class SampleAKTest {
	DriverFactory factory = new DriverFactory();
	WebDriver driver = factory.createDriver(DriverType.CHROME);
	String username="demo";
	String password="demo";
	
	@Test
	public void f() {
		driver.get(CustomUrls.LOGIN.getUrl());
		DriverFactory.takeScreenShot(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginAccount(username, password);
//		HomePage homePage = new HomePage(driver);
//		Assert.assertTrue(homePage.isLoggedIn());
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
