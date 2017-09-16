package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.DriverType;

public class DriverFactory {
	public static WebDriver getDriver(DriverType driverType) {
		WebDriver driver;
		switch (driverType) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}
	
	public static WebDriver getDriver(DriverType driverType,DesiredCapabilities capabilities) {
		WebDriver driver = getDriver(driverType);
		return driver;
	}
	// public static WebDriver getDriver(DriverType driverType) {
	//
	//// Map<String, String> mobileEmulation = new HashMap<String, String>();
	//// mobileEmulation.put("deviceName", "Nexus 5");
	////
	//// Map<String, Object> chromeOptions = new HashMap<String, Object>();
	//// chromeOptions.put("mobileEmulation", mobileEmulation);
	//// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	//// capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	//
	// String dir = System.getProperty("user.dir");
	// System.setProperty("webdriver.chrome.driver",
	// dir+"\\drivers\\chromedriver.exe");
	// WebDriver driver;
	//// switch (driverType) {
	//// case CHROME:
	//// driver = new ChromeDriver(capabilities);
	//// break;
	//// case FIREFOX:
	//// driver = new FirefoxDriver();
	//// break;
	//// default:
	//// driver = new ChromeDriver();
	//// break;
	//// }
	//// return driver;
	// }

	private static void setDriverProperty(String browserType) {
	}
}
