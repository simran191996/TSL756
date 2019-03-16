package testNG;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class para {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void Login(String UN, String PW) 
  {
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:16954781911278626555::NO:::");
	  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).sendKeys(UN);
	  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).sendKeys(PW);
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
  }

  @DataProvider
  public Object[][] dp() {
Object[][] data=new Object[4][2];

data[0][0]="sys";
data[0][1]="Newuser123";
data[1][0]="system";
data[1][1]="Newuser123";
data[2][0]="dgd";
data[2][1]="sjgkjys";
data[3][0]="sjhfys";
data[3][1]="sysd";
	
return data;
  }
  @BeforeTest
  public void beforeTest() 
  {
	  driver=BrowserSetup.browserStart("chrome");
  }

  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}
