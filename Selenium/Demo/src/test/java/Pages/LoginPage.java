package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.utils.WaitUtils;

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
		// explicit wait: the login form must be visible before typing
		WaitUtils.waitForVisible(driver, userNameField).sendKeys(name);
		// implicit wait covers these lookups
		driver.findElement(passwordField).sendKeys(password);
		WaitUtils.waitForClickable(driver, siginBtn).submit();
		return new HomePage(driver);
	}

	public HomePage gotoHome() {
		return new HomePage(driver);
	}

	public ForgotPasswordPage forgotpassword() {
		return new ForgotPasswordPage(driver);
	}
}
