package enums;

public enum FileExtensions {
	PNG("png"),
	LOG("log"),
	HTML("html");
	private String extension;
	private FileExtensions(String extension) {
		this.extension = extension;
	}
	
	public String getExtension() {
		return extension;
	}
	
}
