package TestNg_Day5;

import org.testng.annotations.Test;

import util.Base2;
import util.Keywords;

public class Execute2 extends Base2{
  @Test
  public void f() {
	  Keywords key= new Keywords(driver);
	  key.openUrl("https://opensource-demo.orangehrmlive.com/");
	  
	 key.type("txtUsername_:name", "admin");
	 key.type("txtPassword_:id", "admin123");
	 key.click("//*[@type='submit']_:xpath");
	 key.click("//*[@id='welcome']_:xpath");
	 key.click("Logout_:linktext");
	 
  }
}
