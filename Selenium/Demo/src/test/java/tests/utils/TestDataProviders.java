package tests.utils;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

	@DataProvider(name = "validLogins")
	public static Object[][] validLogins() {
		return new Object[][] { { "admin", "password" } };
	}

	@DataProvider(name = "invalidLogins")
	public static Object[][] invalidLogins() {
		return new Object[][] { { "admin", "wrongPassword" }, { "nobody", "password" }, { "", "" } };
	}

	@DataProvider(name = "newEmployees")
	public static Object[][] newEmployees() {
		String id = String.valueOf(System.currentTimeMillis() % 100000);
		return new Object[][] {
			{ "jothi" + id, "22", "100000", "24", "jothi" + id + "@email.com", 3 },
			{ "dt" + id, "30", "50000", "60", "dt" + id + "@email.com", 2 }
		};
	}

	@DataProvider(name = "unknownEmployees")
	public static Object[][] unknownEmployees() {
		return new Object[][] { { "zzNoSuchEmployeeOne" }, { "zzNoSuchEmployeeTwo" } };
	}
}
