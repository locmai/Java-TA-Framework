package enums;

public enum DriverType {
	CHROME("CHROME", "chromedriver.exe", "webdriver.chrome.driver"),
	FIREFOX("FIREFOX", "geckodriver.exe","webdriver.gecko.driver");
	
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
