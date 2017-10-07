package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	@FindBy(tagName = "title")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//input[@name='userName']")
	private WebElement txtUsername;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//input[@name='login']")
	private WebElement btnLogin;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLoggedIn() {
		System.out.println(getCurrentTitle()+"+sadadsadsaddsa");
		return getCurrentTitle().contains("Find a Flight: Mercury Tours:");
	}
	
	public String getCurrentTitle() {
		return pageTitle.getText();
	}
}
