package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By userNameField = By.name("UserName");
	private By passwordField = By.name("Password");
	private By forgotPasslnk = By.linkText("Forgot password?");
	private By rememberMeCheckBox = By.name("RememberMe");
	private By registerLnk = By.linkText("Create one");
	private By homeLnk = By.linkText("← Back to Home");
	private By siginBtn = By.xpath("//button[text()=\"Sign In\"]");

	public HomePage login(String name, String password) {
		driver.findElement(userNameField).sendKeys(name);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(siginBtn).submit();
		return new HomePage(driver);
	}

	public HomePage gotoHome() {
		return new HomePage(driver);
	}

	public ForgotPasswordPage forgotpassword() {
		return new ForgotPasswordPage(driver);
	}
}
