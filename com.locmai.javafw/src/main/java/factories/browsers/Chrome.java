package factories.browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.openqa.selenium.remote.DesiredCapabilities.chrome;


public class Chrome implements Browser {

	private ChromeOptions options;
	private DesiredCapabilities capabilities;

	private ChromeOptions getOptions() {
		return options;
	}

	private DesiredCapabilities getCapabilities() {
		if (this.capabilities == null) {
			this.capabilities = chrome();
			this.capabilities.setAcceptInsecureCerts(true);
			this.capabilities.setJavascriptEnabled(true);
		}
		return capabilities;
	}
	
	@Override
	public WebDriver createDriver() {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, getOptions());			
		return new ChromeDriver(cap.merge(getCapabilities()));
	}

	@Override
	public void setDriverOptions(Object options) {
		this.options = (ChromeOptions) options;
	}

	@Override
	public void setCapabilities(Object capabilities) {
		this.capabilities = (DesiredCapabilities) capabilities;
	}
}
