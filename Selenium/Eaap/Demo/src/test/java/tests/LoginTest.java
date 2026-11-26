package tests;

import Pages.HomePage;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.utils.TestDataProviders;

public class LoginTest extends BaseTest {

	@Test(
		priority = 1,
		groups = { "smoke", "login" },
		dataProvider = "validLogins",
		dataProviderClass = TestDataProviders.class
	)
	public void validLogin(String user, String password) {
		HomePage homePage = new HomePage(driver).clickLogin().login(user, password);
		Assert.assertTrue(homePage.isLoggedIn(), "Login should succeed for user: " + user);
	}
	//	@Test(
	//		priority = 2,
	//		groups = { "regression", "login" },
	//		dataProvider = "invalidLogins",
	//		dataProviderClass = TestDataProviders.class
	//	)
	//	public void invalidLogin(String user, String password) {
	//		HomePage homePage = new HomePage(driver).clickLogin().login(user, password);
	//		Assert.assertFalse(
	//			homePage.isLoggedIn(Duration.ofSeconds(3)),
	//			"Login should be rejected for user: '" + user + "'"
	//		);
	//	}
}
