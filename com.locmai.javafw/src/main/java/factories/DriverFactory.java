package factories;

import java.util.HashMap;
import java.util.Map;

//Import Selenium Packages
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//Import Enums
import enums.DriverType;
import enums.DeviceType;

//Import Helpers
import helpers.DriverPathHelper;

public class DriverFactory {
	
	public static WebDriver getDriver(DriverType driverType) {
		setSystemProperty(driverType);
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
	
	public static WebDriver getDriver(DriverType driverType,DeviceType deviceType) {
		setSystemProperty(driverType);
		
		WebDriver driver;
		switch (driverType) {
		case CHROME:
			driver = new ChromeDriver(getChromeCapabilities(deviceType));
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
	
	private static DesiredCapabilities getChromeCapabilities(DeviceType device) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", device.getDeviceName());
		Map<String, Object> deviceOptions = new HashMap<String, Object>();
		deviceOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY,deviceOptions);
		return capabilities;
	}

	private static void setSystemProperty(DriverType driverType) {
		String key = driverType.getSystemPropertyKey();
		String driverPath = DriverPathHelper.driverPath(driverType);
		System.setProperty(key, driverPath);
	}
}
