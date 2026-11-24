// page.getByRole() to locate by explicit and implicit accessibility attributes.
// page.getByText() to locate by text content.
// page.getByLabel() to locate a form control by associated label's text.
// page.getByPlaceholder() to locate an input by placeholder.
// page.getByAltText() to locate an element, usually image, by its text alternative.
// page.getByTitle() to locate an element by its title attribute.
// page.getByTestId() to locate an element based on its data-testid attribute (other attributes can be configured).

import { test, expect, Locator } from "@playwright/test";

// test("built-in getByAltText locators", async ({ page }) => {
//   await page.goto("https://eaapp.somee.com/");
//   const logo: Locator = page.getByAltText("EAEmployee Logo");
//   await expect(logo).toBeVisible();
// });

// test("getByText locator", async ({ page }) => {
//   await page.goto("https://eaapp.somee.com/");
//   await expect(page.getByText("Employee Management")).toBeVisible();
// });

test("getByRole AND getByLabel locator", async ({ page }) => {
  await page.goto("https://eaapp.somee.com/");
  await page.getByRole("link", { name: "Login" }).click();
  await expect(page.getByText("Welcome back")).toBeVisible();
  await page.getByLabel("User Name").fill("Admin");
  await page.getByLabel("Password").fill("password");
  await page.getByRole("button", { name: "Sign In" }).click();
  expect(page.getByTitle("Manage")).toHaveText("Hello admin!");
});
