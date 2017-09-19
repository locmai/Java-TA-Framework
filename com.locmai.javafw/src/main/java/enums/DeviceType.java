package enums;

public enum DeviceType {
	NEXUS_4("Nexus 4"),
	NEXUS_5("Nexus 5"),
	IPAD_MINI("iPad Mini");
	private String deviceName;
	private DeviceType(String deviceName) {
		this.setDeviceName(deviceName);
		
	}
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
}
