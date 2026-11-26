package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://192.168.1.10:6890/login");
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.linkText("Proceed to 192.168.1.10 (unsafe)")).click();
		driver.findElement(By.xpath("//span[contains(text(),\" Continue with Microsoft \")]")).click();
		Thread.sleep(5000);
	}
}
