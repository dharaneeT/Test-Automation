package Pages;

import Utils.WaitUtils;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class=\"excelencia-logo\"]")
	private WebElement cmpLogo;

	@FindBy(xpath = "//span[contains(text(),\" Continue with Microsoft \")]")
	private WebElement msBtn;

	@FindBy(id = "i0116")
	private WebElement emailField;

	@FindBy(linkText = "Can’t access your account?")
	private WebElement cantAccessLnk;

	@FindBy(id = "idSIButton9")
	private WebElement nextBtn;

	@FindBy(id = "i0118")
	private WebElement passwordField;

	@FindBy(linkText = "Forgot my password")
	private WebElement forgotPassword;

	@FindBy(id = "idSIButton9")
	private WebElement siginBtn;

	public DashboardPage enterInput(String email, String password) {
		WaitUtils.waitForClickable(driver, emailField).sendKeys(email);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WaitUtils.waitForClickable(driver, nextBtn).submit();
		WaitUtils.waitForClickable(driver, passwordField).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WaitUtils.waitForClickable(driver, siginBtn).submit();
		return new DashboardPage(driver);
	}

	public void clickLogin() {
		WaitUtils.waitForClickable(driver, msBtn).click();
	}
}
