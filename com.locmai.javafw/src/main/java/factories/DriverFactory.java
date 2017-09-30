package factories;

import java.util.HashMap;
import java.util.Map;

//Import Selenium Packages
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.DeviceType;
//Import Enums
import enums.DriverType;
import factories.browsers.Chrome;
import factories.browsers.Firefox;
import utilities.PathHelper;

public class DriverFactory {

	public WebDriver createDriver(DriverType driverType) {
		setSystemProperty(driverType);

		switch (driverType) {
		case CHROME:
			return new ChromeDriver();
		case FIREFOX:
			return new FirefoxDriver();
		case CHROME_IPAD:
			return MobileDriver(driverType.getBrowserName());
		case CHROME_NEXUS5:
			return MobileDriver(driverType.getBrowserName());
		default:
			return new Chrome().createDriver();
		}
	}

	private ChromeDriver MobileDriver(String deviceName) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", deviceName);
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return new ChromeDriver(capabilities);
	}
	
	// Set System Property
	private void setSystemProperty(DriverType driverType) {
		String key = driverType.getSystemPropertyKey();
		String driverPath = PathHelper.driverPath(driverType);
		System.setProperty(key, driverPath);
	}
}
