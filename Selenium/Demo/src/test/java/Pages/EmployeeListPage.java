package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeListPage {

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
		newEmpLnk.click();
		return new CreateEmpPage(driver);
	}

	public void findEmp(String name, String mail, int gradeindex) throws InterruptedException {
		nameField.sendKeys(name);
		emailField.sendKeys(mail);

		Select gradeSelect = new Select(gradeFilter);
		gradeSelect.selectByIndex(gradeindex);

		searchBtn.click();

		Thread.sleep(5000);
	}

	public void clearList() {
		clearLnk.click();
	}
}
