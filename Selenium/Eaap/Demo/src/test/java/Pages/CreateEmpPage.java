package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import tests.utils.WaitUtils;

public class CreateEmpPage {

	private WebDriver driver;

	public CreateEmpPage(WebDriver driver) {
		this.driver = driver;
	}

	private By nameField = By.name("Name");
	private By ageField = By.name("Age");
	private By salaryField = By.name("Salary");
	private By durationWorkedField = By.name("DurationWorked");
	private By mailField = By.name("Email");
	private By backToListLnk = By.linkText("← Back to List");
	private By createBtn = By.xpath("//button[text()=\"✓ Create Employee\"]");
	private By cancelLnk = By.xpath("//a[contains(text(), '✕ Cancel')]");
	private By gradeselectelement = By.name("Grade");

	public EmployeeListPage createEmployee(
		String name,
		String age,
		String salary,
		String durationWorked,
		String email,
		int gradeindex
	) {
		WaitUtils.waitForVisible(driver, nameField).sendKeys(name);
		driver.findElement(ageField).sendKeys(age);
		driver.findElement(salaryField).sendKeys(salary);
		driver.findElement(durationWorkedField).sendKeys(durationWorked);
		Select gradeSelect = new Select(driver.findElement(gradeselectelement));
		gradeSelect.selectByIndex(gradeindex);
		driver.findElement(mailField).sendKeys(email);

		WaitUtils.waitForClickable(driver, createBtn).submit();

		WaitUtils.waitForUrlNotContaining(driver, "Create");
		return new EmployeeListPage(driver);
	}

	public void cancel() {
		WaitUtils.waitForClickable(driver, cancelLnk).click();
	}
}
