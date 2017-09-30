package enums;

public enum DriverType {
	CHROME("Chrome", "chromedriver.exe", "webdriver.chrome.driver"),
	FIREFOX("Firefox", "geckodriver.exe","webdriver.gecko.driver"), 
	CHROME_IPAD("iPad Mini", "chromedriver.exe", "webdriver.chrome.driver"),
	CHROME_NEXUS5("Nexus 5", "chromedriver.exe", "webdriver.chrome.driver");
	
	private String browserName;
	private String executableFileName;
	private String systemPropertyKey;
	
	private DriverType(String browserName, String executableFileName, String systemPropertyKey) {
		this.browserName = browserName;
		this.executableFileName = executableFileName;
		this.systemPropertyKey = systemPropertyKey;
	}

	public String getBrowserName() {
		return browserName;
	}

	public String getExecutableFileName() {
		return executableFileName;
	}

	public String getSystemPropertyKey() {
		return systemPropertyKey;
	}
}
