package tests;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://eaapp.somee.com/");
		HomePage homePage = new HomePage(driver);
		var loginpage = homePage.clickLogin();
		loginpage.login("admin", "password");
		var employeeList = homePage.clickEmployeeList();
		var createEmp = employeeList.createEmp();
		createEmp.createEmployee("jot", "22", "100000", "24", "jot@email.com", 2);
		Thread.sleep(5000);
		driver.quit();
	}
}
