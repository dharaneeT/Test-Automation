package Utils;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

	@DataProvider(name = "validLogin")
	public static Object[][] validLogins() {
		return new Object[][] { { "dharshini.vijayan@excelenciaconsulting.com", "Diaz@2618" } };
	}
	//	@DataProvider(name = "validPassword")
	//	public static Object[][] invalidLogins() {
	//		return ew Object[][] { { "Diaz@2618" } };
	//	}
	//	@DataProvider(name = "newEmployees")
	//	public static Object[][] newEmployees() {
	//		String id = String.valueOf(System.currentTimeMillis() % 100000);
	//		return new Object[][] {
	//			{ "jothi" + id, "22", "100000", "24", "jothi" + id + "@email.com", 3 },
	//			{ "dt" + id, "30", "50000", "60", "dt" + id + "@email.com", 2 }
	//		};
	//	}
	//
	//	@DataProvider(name = "unknownEmployees")
	//	public static Object[][] unknownEmployees() {
	//		return new Object[][] { { "zzNoSuchEmployeeOne" }, { "zzNoSuchEmployeeTwo" } };
	//	}
}
