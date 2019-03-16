package testNg_Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base;

public class Depends extends Base{

	  @Test
	  public void f1() {
		  System.out.println("In Test1");
		  driver.get("http://google.com");
		  Assert.assertEquals(driver.getTitle(),"Google");
	  }
	  @Test(dependsOnMethods="f1")
	  public void f2() {
		  System.out.println("In Test2");
		  boolean display=driver.findElement(By.name("q")).isDisplayed();
		  Assert.assertTrue(display);
	  }
	  @Test(dependsOnMethods="f2")
	  public void f3() throws Exception{
		  String data="MODI";
		  System.out.println("In Test3");
		  driver.findElement(By.name("q")).sendKeys(data);
		 // Thread.sleep(2000);
		  new WebDriverWait(driver,20).
		  until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		  
		  driver.findElement(By.name("btnK")).click();
		  Assert.assertEquals(driver.getTitle(),data+" - Google Search");
		  }
	}


