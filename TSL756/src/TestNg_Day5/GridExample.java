package TestNg_Day5;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class GridExample {
	
  @Test
  public void f() throws Exception{
	 DesiredCapabilities dc=  DesiredCapabilities.firefox();
	  dc.setPlatform(Platform.WINDOWS);
	  dc.setBrowserName("firefox");
	// WebDriver driver=new RemoteWebDriver(new URL(" http://192.168.100.177:15057/wd/hub"),dc );
	  WebDriver driver1=new RemoteWebDriver(new URL(" http://192.168.100.147:48705/wd/hub"),dc );
	  //driver.get("http://seleniumhq.org");
	  driver1.get("http://seleniumhq.org");

      //Assert.assertEquals(driver.getTitle(), "Selenium - Web Browser Automation");
      Assert.assertEquals(driver1.getTitle(), "Selenium - Web Browser Automation");

	  //driver.quit(); 
	  driver1.quit();
  
  }
  
  
}
