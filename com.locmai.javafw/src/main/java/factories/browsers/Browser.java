package factories.browsers;

import org.openqa.selenium.WebDriver;

public interface Browser {
	WebDriver createDriver();

	public void setDriverOptions(Object options);

	public void setCapabilities(Object capabilities);
}
