package enums;

public enum DriverType {
	CHROME("CHROME", "chromedriver.exe", "webdriver.chrome.driver"),
	FIREFOX("FIREFOX", "geckodriver.exe","webdriver.gecko.driver");
	
	private String browserName;
	private String executableFileName;
	private String systemPropertyKey;
	
	private DriverType(String browserName, String executableFileName, String systemPropertyKey) {
		this.setBrowserName(browserName);
		this.setExecutableFileName(executableFileName);
		this.setSystemPropertyKey(systemPropertyKey);
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getExecutableFileName() {
		return executableFileName;
	}

	public void setExecutableFileName(String executableFileName) {
		this.executableFileName = executableFileName;
	}

	public String getSystemPropertyKey() {
		return systemPropertyKey;
	}

	public void setSystemPropertyKey(String systemPropertyKey) {
		this.systemPropertyKey = systemPropertyKey;
	}
}
