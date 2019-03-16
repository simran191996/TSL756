package util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Base2 {
	public WebDriver driver;
 
	@BeforeTest(alwaysRun=true)
	public void beforeTest() {
		driver = BrowserSetup.browserStart("Chrome");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
