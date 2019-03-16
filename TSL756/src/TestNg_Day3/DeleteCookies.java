package TestNg_Day3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Base;
import util.Excel;

public class DeleteCookies extends Base {

	
  @Test
  public void Oracle() throws Exception {
	  
		driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:16954781911278626555::NO:::");
		driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).clear();
		driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).sendKeys("system");
		driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).clear();
		driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).sendKeys("Newuser123");
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
		  driver.manage().deleteAllCookies();

		  driver.navigate().refresh();										//to refresh the page
		//  driver.findElement(By.linkText("SQL")).click();
		  
		//  Assert.assertEquals(driver.getTitle(), "HTML DB Login");
		 Assert.assertTrue(driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).isDisplayed());
	
		  Thread.sleep(4000);
  }
}
