package Day7Junit;
import static org.junit.Assert.*;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import util.BrowserSetup;

public class HeadLess {
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	/*System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--headless");
		
		
		 driver=new ChromeDriver(op);//child object-so child functio viewed
		driver.manage().window().maximize();*/
		
	/*	driver = new HtmlUnitDriver(true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		
		System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe ");
		FirefoxOptions op=new FirefoxOptions();
		
		op.addArguments("--headless");
		
		 driver=new FirefoxDriver(op);//child object-so child functio viewed
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {

		driver.get("http://google.com");
		assertEquals("Google",driver.getTitle());
		//assertTrue(driver.findElement(By.linkText("Maven users")).isDisplayed());
		assertTrue(driver.findElement(By.name("q")).isDisplayed());
	}

}
