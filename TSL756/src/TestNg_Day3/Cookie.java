package TestNg_Day3;

import java.sql.Driver;
import java.util.Set;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import util.*;
public class Cookie extends Base {
  @Test
  public void Google() {

	  driver.get("http://google.com");
	  
	  	//	Set<Cookie> all=driver.manage().getCookies();

			/*		Set<org.openqa.selenium.Cookie> all=	driver.manage().getCookies();

//Set<Cookie> allCookies = driver.manage().getCookies();

for(Cookie C: all)
{
	System.out.println("Cookie Name is "+C.getName());
	System.out.println("Cookie Domain is "+ C.getDomain());
	System.out.println("Cookie Expiry is "+C.getExpiry());
	System.out.println("Cookie Value is "+C.getValue());
	System.out.println("Cookie Path is "+C.getPath());
	
}
	*/
  }
}
