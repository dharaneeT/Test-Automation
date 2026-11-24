package tests;

import Pages.CreateEmpPage;
import Pages.EmployeeListPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EapTest {

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private EmployeeListPage employeeListPage;
	private CreateEmpPage createEmpPage;

	@BeforeTest
	public void RunBeforeTest() {
		driver = new ChromeDriver();
		driver.navigate().to("https://eaapp.somee.com/");
		homePage = new HomePage(driver);
		loginPage = homePage.clickLogin();
		loginPage.login("admin", "password");
	}

	@Test
	public void createEmployee() throws InterruptedException {
		employeeListPage = homePage.clickEmployeeList();
		createEmpPage = employeeListPage.createEmp();
		createEmpPage.createEmployee("joth", "22", "100000", "24", "joth@email.com", 3);
		Thread.sleep(5000);
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("Browser is quitting");
		driver.quit();
	}
}
