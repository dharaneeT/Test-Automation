package tests.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitUtils {

	public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(5);

	public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(15);
	private static final Duration POLLING = Duration.ofMillis(250);

	private WaitUtils() {}

	public static <T> T until(WebDriver driver, ExpectedCondition<T> condition, Duration timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ZERO);
		try {
			return new WebDriverWait(driver, timeout, POLLING).until(condition);
		} finally {
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
		}
	}

	public static WebElement waitForVisible(WebDriver driver, By locator) {
		return until(driver, ExpectedConditions.visibilityOfElementLocated(locator), EXPLICIT_WAIT);
	}

	public static WebElement waitForVisible(WebDriver driver, WebElement element) {
		return until(driver, ExpectedConditions.visibilityOf(element), EXPLICIT_WAIT);
	}

	public static WebElement waitForClickable(WebDriver driver, By locator) {
		return until(driver, ExpectedConditions.elementToBeClickable(locator), EXPLICIT_WAIT);
	}

	public static WebElement waitForClickable(WebDriver driver, WebElement element) {
		return until(driver, ExpectedConditions.elementToBeClickable(element), EXPLICIT_WAIT);
	}

	public static void waitForUrlContaining(WebDriver driver, String fragment) {
		until(driver, ExpectedConditions.urlContains(fragment), EXPLICIT_WAIT);
	}

	public static void waitForUrlNotContaining(WebDriver driver, String fragment) {
		until(driver, ExpectedConditions.not(ExpectedConditions.urlContains(fragment)), EXPLICIT_WAIT);
	}

	public static void waitForStale(WebDriver driver, WebElement element) {
		until(driver, ExpectedConditions.stalenessOf(element), EXPLICIT_WAIT);
	}

	public static boolean isPresent(WebDriver driver, By locator, Duration timeout) {
		try {
			until(driver, ExpectedConditions.presenceOfElementLocated(locator), timeout);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public static boolean isGone(WebDriver driver, WebElement element, Duration timeout) {
		try {
			return until(driver, ExpectedConditions.invisibilityOf(element), timeout);
		} catch (TimeoutException e) {
			return false;
		}
	}
}
