import { test, expect, Locator } from "@playwright/test";

// test("Login", async ({ page }) => {
//   await page.goto(
//     "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
//   );
//   await page.getByPlaceholder("Username").fill("Admin");
//   await page.getByPlaceholder("Password").fill("admin123");
//   await page.getByRole("button", { name: "Login" }).click();
// });

test("Select single Dropdown", async ({ page }) => {
  await page.goto(
    "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
  );
  await page.getByPlaceholder("Username").fill("Admin");
  await page.getByPlaceholder("Password").fill("admin123");
  await page.getByRole("button", { name: "Login" }).click();
  await page.getByText("John Doe").click();
  await page.getByRole("link", { name: "About" }).click();
});
