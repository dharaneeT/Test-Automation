package tests.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import tests.utils.WaitUtils;

public class BaseTest {

	protected static final String BASE_URL = "https://eaapp.somee.com/";

	protected WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser) {
		driver = createDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitUtils.IMPLICIT_WAIT);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.navigate().to(BASE_URL);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	private WebDriver createDriver(String browser) {
		return switch (browser.toLowerCase()) {
			case "chrome" -> new ChromeDriver();
			case "firefox" -> new FirefoxDriver();
			case "edge" -> new EdgeDriver();
			default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
		};
	}
}
