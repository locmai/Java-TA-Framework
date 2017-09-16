package sample;

import org.testng.annotations.Test;
//External
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//Core 
import enums.DriverType;
import factories.DriverFactory;

public class SampleTest {
	WebDriver driver = DriverFactory.getDriver(DriverType.CHROME);

	@Test
	public void f() {
		Assert.assertEquals("What browser am I using? Is my browser up to date?", driver.getTitle());
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://www.whatismybrowser.com/");
	}

	@AfterTest
	public void afterTest() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
