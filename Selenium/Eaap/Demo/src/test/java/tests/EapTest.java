package tests;

import Pages.CreateEmpPage;
import Pages.EmployeeListPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.utils.TestDataProviders;

public class EapTest extends BaseTest {

	private HomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void loginAsAdmin() {
		homePage = new HomePage(driver);
		homePage.clickLogin().login("admin", "password");
		Assert.assertTrue(homePage.isLoggedIn(), "Pre-condition failed: admin could not log in");
	}

	@Test(
		priority = 1,
		groups = { "regression", "employee" },
		dataProvider = "newEmployees",
		dataProviderClass = TestDataProviders.class
	)
	public void createEmployee(
		String name,
		String age,
		String salary,
		String durationWorked,
		String email,
		int gradeIndex
	) {
		EmployeeListPage listPage = homePage.clickEmployeeList();
		CreateEmpPage createPage = listPage.createEmp();
		listPage = createPage.createEmployee(name, age, salary, durationWorked, email, gradeIndex);

		listPage.searchByName(name);
		Assert.assertTrue(listPage.isEmployeeListed(name), "Employee should be listed: " + name);
	}

	@Test(
		priority = 2,
		groups = { "regression", "employee" },
		dataProvider = "unknownEmployees",
		dataProviderClass = TestDataProviders.class
	)
	public void searchUnknownEmployee(String unknownName) {
		EmployeeListPage listPage = homePage.clickEmployeeList();
		listPage.searchByName(unknownName);
		Assert.assertFalse(
			listPage.isEmployeeListed(unknownName),
			"Unknown employee should not be listed: " + unknownName
		);
	}

	@Test(priority = 3, groups = { "regression", "employee" })
	public void cancelCreateEmployee() {
		CreateEmpPage createPage = homePage.clickEmployeeList().createEmp();
		createPage.cancel();
		//		Assert.assertFalse(driver.getCurrentUrl().contains("Create"), "Cancel should leave the Create page");
	}
}
