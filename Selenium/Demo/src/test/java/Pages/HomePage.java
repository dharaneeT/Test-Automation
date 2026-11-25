package Pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.utils.WaitUtils;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Login")
	private WebElement loginlnk;

	@FindBy(linkText = "\uD83C\uDFE0 Home")
	private WebElement homelnk;

	@FindBy(linkText = "\uD83D\uDC65 Employees")
	private WebElement employeelnk;

	@FindBy(linkText = "\uD83D\uDCCA Dashboard")
	private WebElement dashboarlnk;

	@FindBy(linkText = "ℹ\uFE0F About")
	private WebElement aboutlnk;

	@FindBy(linkText = "Register")
	private WebElement registerlnk;

	@FindBy(css = "brand-icon")
	private WebElement logo;

	public LoginPage clickLogin() {
		WaitUtils.waitForClickable(driver, loginlnk).click();
		return new LoginPage(driver);
	}

	public RegisterPage clickRegister() {
		WaitUtils.waitForClickable(driver, registerlnk).click();
		return new RegisterPage(driver);
	}

	public DashboardPage clickDashboard() {
		WaitUtils.waitForClickable(driver, dashboarlnk).click();
		return new DashboardPage(driver);
	}

	public AboutPage clickAbout() {
		WaitUtils.waitForClickable(driver, aboutlnk).click();
		return new AboutPage(driver);
	}

	public EmployeeListPage clickEmployeeList() {
		WaitUtils.waitForClickable(driver, employeelnk).click();
		return new EmployeeListPage(driver);
	}

	public boolean isLoggedIn() {
		return isLoggedIn(WaitUtils.EXPLICIT_WAIT);
	}

	public boolean isLoggedIn(Duration timeout) {
		return WaitUtils.isGone(driver, loginlnk, timeout);
	}
}
