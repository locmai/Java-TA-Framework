package sample;

//External
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import enums.DeviceType;
//Core 
import enums.DriverType;
import factories.DriverFactory;

public class SampleTest {
	WebDriver driver = DriverFactory.getDriver(DriverType.CHROME,DeviceType.IPAD_MINI);
	//WebDriver driver = DriverFactory.getDriver(DriverType.CHROME);
	@Test
	public void f() {
		driver.get("https://www.whatismybrowser.com/");
		Assert.assertEquals("What browser am I using? Is my browser up to date?", driver.getTitle());
	}

	@BeforeTest
	public void beforeTest() {
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
