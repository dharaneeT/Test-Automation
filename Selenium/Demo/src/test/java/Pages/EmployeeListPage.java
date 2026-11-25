package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tests.utils.WaitUtils;

public class EmployeeListPage {

	private static final By SEARCH_BTN = By.xpath("//button[text()='Search']");

	private WebDriver driver;

	public EmployeeListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "+ New Employee")
	private WebElement newEmpLnk;

	@FindBy(name = "searchTerm")
	private WebElement nameField;

	@FindBy(name = "emailTerm")
	private WebElement emailField;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchBtn;

	@FindBy(linkText = "✕ Clear")
	private WebElement clearLnk;

	@FindBy(name = "gradeFilter")
	private WebElement gradeFilter;

	public CreateEmpPage createEmp() {
		WaitUtils.waitForClickable(driver, newEmpLnk).click();
		return new CreateEmpPage(driver);
	}

	public void findEmp(String name, String mail, int gradeindex) {
		WaitUtils.waitForVisible(driver, nameField).clear();
		nameField.sendKeys(name);
		emailField.clear();
		emailField.sendKeys(mail);

		Select gradeSelect = new Select(gradeFilter);
		gradeSelect.selectByIndex(gradeindex);

		submitSearch();
	}

	public void searchByName(String name) {
		WaitUtils.waitForVisible(driver, nameField).clear();
		nameField.sendKeys(name);
		submitSearch();
	}

	public boolean isEmployeeListed(String name) {
		By row = By.xpath("//table//td[contains(normalize-space(.),'" + name + "')]");
		return WaitUtils.isPresent(driver, row, Duration.ofSeconds(5));
	}

	public void clearList() {
		WaitUtils.waitForClickable(driver, clearLnk).click();
	}



	private void submitSearch() {
		WebElement before = driver.findElement(SEARCH_BTN);
		WaitUtils.waitForClickable(driver, searchBtn).click();
		WaitUtils.waitForStale(driver, before);
		WaitUtils.waitForVisible(driver, searchBtn);
	}
}
