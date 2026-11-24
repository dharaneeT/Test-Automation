import { test, expect, Locator } from "@playwright/test";

// test("login", async ({ page }) => {
//   await page.goto(
//     "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
//   );
//   await expect(page.getByAltText("company-branding")).toBeVisible();

//   await page.getByPlaceholder("Username").fill("Admin");
//   await page.getByPlaceholder("Password").fill("admin123")  await page.getByRole("button", { name: "Login" }).click();
//   await page.waitForTimeout(5000);
// });

//NOTE:Text input action
test("Title", async ({ page }) => {
  await page.goto("https://testautomationpractice.blogspot.com/");
  await expect(page).toHaveTitle("Automation Testing Practice");
  await expect(page).toHaveURL("https://testautomationpractice.blogspot.com/");
});

test("Name TextBoxes", async ({ page }) => {
  await page.goto("https://testautomationpractice.blogspot.com/");
  const name: Locator = page.locator("#name");
  await expect(name).toBeVisible();
  await expect(name).toBeEnabled();
  await expect(name).toHaveAttribute("maxlength", "15");
  await name.fill("Dharanee");
  await page.waitForTimeout(1000);
});

test("Email TextBoxes", async ({ page }) => {
  await page.goto("https://testautomationpractice.blogspot.com/");
  const name: Locator = page.locator("#email");
  await expect(name).toBeVisible();
  await expect(name).toBeEnabled();
  await expect(name).toHaveAttribute("maxlength", "25");
  await name.fill("dharanee@gmail.com");
  await page.waitForTimeout(1000);
});

test("radio-btn", async ({ page }) => {
  await page.goto("https://testautomationpractice.blogspot.com/");
  const maleBtn: Locator = page.locator("#male");
  await expect(maleBtn).toBeVisible();
  expect(maleBtn).not.toBeChecked();
  await maleBtn.check();
  await expect(maleBtn).toBeChecked();
});

test("checkboxes", async ({ page }) => {
  await page.goto("https://testautomationpractice.blogspot.com/");
  const boxNames: string[] = [
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
  ];
  const checkboxes: Locator[] = boxNames.map((i) => page.getByLabel(i));
  for (const checkbox of checkboxes) {
    await expect(checkbox).not.toBeChecked();
    await checkbox.check();
    await expect(checkbox).toBeChecked();
  }
});
