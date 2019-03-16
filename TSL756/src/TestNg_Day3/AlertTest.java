package TestNg_Day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Base;

public class AlertTest  extends Base{
  @Test
  public void f() throws Exception {
	  driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
	  driver.findElement(By.xpath("//button[@onclick='myFunction1()']")).click();
	  Alert A=driver.switchTo().alert();
	  String txt=A.getText();
	  System.out.println(txt);
	  Thread.sleep(2000);
	  A.accept();
	  Thread.sleep(2000);

	  
	  driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
	  Alert A2=driver.switchTo().alert();
	  String txt1=A.getText();
	  System.out.println(txt1);
	  Thread.sleep(2000);
	  A2.sendKeys("SIMRAN");
	  
	  Thread.sleep(2000);
     A2.accept();
     

  }
}
