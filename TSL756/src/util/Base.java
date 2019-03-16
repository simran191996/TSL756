package util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Base {
	public WebDriver driver;
 
	@BeforeTest(alwaysRun=true)
	@Parameters("browser")
	public void beforeTest(String browser) {
		if( browser.equalsIgnoreCase("chrome"))
		driver = BrowserSetup.browserStart("Chrome");
		else if( browser.equalsIgnoreCase("firefox"))
				driver = BrowserSetup.browserStart("firefox");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
