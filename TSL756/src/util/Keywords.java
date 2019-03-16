package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {

	private WebDriver driver;

	public Keywords(WebDriver driver) {
		this.driver = driver;
	}

	public void openUrl(String url) {
		driver.get(url);
	}

	public void type(String locator, String text) {
		driver.findElement(findType(locator)).sendKeys(text);
	}

	public void click(String locator) {
		driver.findElement(findType(locator)).click();
		;
	}

	public void dropDown(String locator, String visibleText) {
		new Select(driver.findElement(findType(locator))).selectByVisibleText(locator);
	}

	public void explicitWait(String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(findType(locator)));

	}

	public WebDriver browserStart(String name, String url) {

		WebDriver driver = browserStart(name);
		driver.get(url);
		return driver;
	}

	public void getScreenShot(String Name) {
		TakesScreenshot screen = (TakesScreenshot) driver;
		String timestamp = new SimpleDateFormat("yyyy_MMM_dd__hh_mm_ss").format(new Date());

		File src = screen.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(".\\" + Name + timestamp + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver browserStart(String name) {

		if (name.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe ");
			driver = new ChromeDriver();// child object-so child functio viewed
		} else if (name.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe ");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public By findType(String value) {
		By b = null;
		if (value.endsWith("_:linktext"))
			b = By.linkText(value.split("_:")[0]);
		else if (value.endsWith("_:xpath"))
			b = By.xpath(value.split("_:")[0]);
		else if (value.endsWith("_:id"))
			b = By.id(value.split("_:")[0]);
		else if (value.endsWith("_:cssselector"))
			b = By.cssSelector(value.split("_:")[0]);
		else if (value.endsWith("_:name"))
			b = By.name(value.split("_:")[0]);
		else
			System.out.println("wrong value");
		return b;
	}

}
