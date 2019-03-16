package TestNg_Day5;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Base2;
import util.Excel;
import util.Keywords;

public class Hybrid extends Base2 {
	@Test(dataProvider = "dp")
	public void f(String key, String Locator, String data) {
		Keywords K = new Keywords(driver);
		switch (key) {
		case "openUrl":
			K.openUrl(data);
			break;
		case "type":
			K.type(Locator, data);
			break;

		case "click":
			K.click(Locator);
			break;
		case "getScreenShot":
			K.getScreenShot(data);
			break;
		default:
			System.out.println("Invalid Key");
		}
	}

	@DataProvider
	public Object[][] dp() {
		Excel ex = new Excel("D:\\Book1.xlsx");
		System.out.println(ex.rowCount("Sheet1") + 1);
		Object data[][] = new Object[ex.rowCount("Sheet1")][3];
		for (int i = 0; i < ex.rowCount("Sheet1"); i++) {
			data[i][0] = ex.Read("Sheet1", i + 1, 0);
			data[i][1] = ex.Read("Sheet1", i + 1, 1);
			data[i][2] = ex.Read("Sheet1", i + 1, 2);
		}

		return data;
	}
}
