package testNg_Day4;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Base2;

public class TestSelenium extends Base2 {
  @Test
  public void LoginProcess() throws Exception {

	  Login login= new Login(driver);
	  driver.get("http://127.0.0.1:8080/htmldb");
	  login.LoginProcess("sys", "Newuser123");
	  System.out.println("login done");
  }
  
  @Test(dependsOnMethods="LoginProcess")
  public void execute() throws Exception {
	  
	  Sql_Command sql= new Sql_Command(driver);
	  SqlHome shome=new SqlHome(driver);
	  
	  shome.startSql();
	  
	 // sql.startSql();
	 Thread.sleep(1000);
	  sql.startsqlComm();
	  Thread.sleep(1000);
	  sql.executeCommand();
	  Thread.sleep(1000);
	   sql.logoutProcess();
	  Thread.sleep(1000);

  }
}
