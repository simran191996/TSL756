package Day7Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import util.Base;

public class Scrolling extends Base{
  @Test
  public void f() throws Exception {
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  driver.get("http://seleniumhq.org");
	  
	  js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.linkText("Selenium blog")));
	  Thread.sleep(4000);
	 
	  js.executeScript("window.scrollBy(0, -700)");
	  Thread.sleep(4000);

	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
Thread.sleep(4000);

js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

Thread.sleep(4000);

  }
}
