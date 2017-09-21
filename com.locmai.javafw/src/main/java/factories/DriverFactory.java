package factories;

import java.util.HashMap;
import java.util.Map;

//Import Selenium Packages
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.DeviceType;
//Import Enums
import enums.DriverType;
import utilities.PathHelper;

public class DriverFactory {

	public static WebDriver getDriver(DriverType driverType) {
		setSystemProperty(driverType);
		@SuppressWarnings("unused")
		WebDriver driver;
		switch (driverType) {
		case CHROME:
			return new ChromeDriver();
		case FIREFOX:
			return new FirefoxDriver();
		default:
			return new ChromeDriver();
		}
	}

	public static WebDriver getDriver(DriverType driverType, DeviceType deviceType) {
		setSystemProperty(driverType);

		WebDriver driver;
		switch (driverType) {
		case CHROME:
			driver = new ChromeDriver(getChromeCapabilities(deviceType));
			break;
		case FIREFOX:
			driver = new FirefoxDriver(getFirefoxCapabilities(deviceType));
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}

	// Set Chrome Capabilities
	private static DesiredCapabilities getChromeCapabilities(DeviceType device) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", device.getDeviceName());
		Map<String, Object> deviceOptions = new HashMap<String, Object>();
		deviceOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, deviceOptions);
		return capabilities;
	}

	private static DesiredCapabilities getFirefoxCapabilities(DeviceType device) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", device.getDeviceName());
		Map<String, Object> deviceOptions = new HashMap<String, Object>();
		deviceOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, deviceOptions);
		return capabilities;
	}

	// Set System Property
	private static void setSystemProperty(DriverType driverType) {
		String key = driverType.getSystemPropertyKey();
		String driverPath = PathHelper.driverPath(driverType);
		System.setProperty(key, driverPath);
	}
}
