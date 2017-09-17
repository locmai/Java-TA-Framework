/**
 * 
 */
package sample;

import helpers.DriverPathHelper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.*;

/**
 * @author AlvissD
 *
 */
public class SampleWithMain {

	/**
	 * @param args
	 */
	private final static String driverPath = DriverPathHelper.driverPath(DriverType.CHROME);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(driverPath);
		
//		Map<String, String> mobileEmulation = new HashMap<String, String>();
//		mobileEmulation.put("deviceName", "Nexus 5");
//		Map<String, Object> chromeOptions = new HashMap<String, Object>();
//		chromeOptions.put("mobileEmulation", mobileEmulation);
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		DesiredCapabilities capabilities2 = DesiredCapabilities.firefox();
//		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, chromeOptions);
//		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	}

}
