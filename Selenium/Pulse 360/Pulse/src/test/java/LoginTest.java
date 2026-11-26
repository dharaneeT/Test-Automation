import Base.BaseTest;
import Pages.LoginPage;
import Utils.TestDataProviders;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(
		priority = 1,
		groups = { "smoke", "login" },
		dataProvider = "validLogin",
		dataProviderClass = TestDataProviders.class
	)
	public void validLogin(String email, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLogin();
		loginPage.enterInput(email, password);
		Thread.sleep(5000);
	}
}
