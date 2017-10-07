package factories;

//Java Common
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//Import Selenium Packages
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//Import Enums
import enums.DriverType;
import utilities.PathHelper;

//Apache Commons
import org.apache.commons.io.FileUtils;

public class DriverFactory {

	public WebDriver createDriver(DriverType driverType) {
		setSystemProperty(driverType);

		switch (driverType) {
		case CHROME:
			return new ChromeDriver();
		case FIREFOX:
			return new FirefoxDriver();
		case IPAD:
			return MobileDriver(driverType.getBrowserName());
		case NEXUS5:
			return MobileDriver(driverType.getBrowserName());
		default:
			return new ChromeDriver();
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

	
	public static void takeScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotDir = PathHelper.createFile("reports", timeStamp() + ".png");
		File tmpFile = new File(screenshotDir);
		try {
			FileUtils.copyFile(src, tmpFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot taken and saved:" + screenshotDir);
	}
	
	private static String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	
}
