package sample.urls;

public enum CustomUrls {
	LOGIN("http://newtours.demoaut.com/mercurysignon.php"),
	HOME("http://newtours.demoaut.com/");
	
	private String url;
	
	private CustomUrls(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
