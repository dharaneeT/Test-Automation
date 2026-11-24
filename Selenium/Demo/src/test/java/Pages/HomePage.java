package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		loginlnk.click();
		return new LoginPage(driver);
	}

	public RegisterPage clickRegister() {
		registerlnk.click();
		return new RegisterPage(driver);
	}

	public DashboardPage clickDashboard() {
		dashboarlnk.click();
		return new DashboardPage(driver);
	}

	public AboutPage clickAbout() {
		aboutlnk.click();
		return new AboutPage(driver);
	}

	public EmployeeListPage clickEmployeeList() {
		employeelnk.click();
		return new EmployeeListPage(driver);
	}
}
