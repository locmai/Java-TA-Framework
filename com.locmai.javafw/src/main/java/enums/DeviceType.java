package enums;

public enum DeviceType {
	NEXUS_4("Nexus 4"),
	NEXUS_5("Nexus 5"),
	IPAD_MINI("iPad Mini");
	private String deviceName;
	private DeviceType(String deviceName) {
		this.deviceName = deviceName;	
	}
	
	public String getDeviceName() {
		return deviceName;
	}
}
