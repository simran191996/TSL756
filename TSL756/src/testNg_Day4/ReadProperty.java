package testNg_Day4;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Base2;

public class ReadProperty extends Base2 {
  @Test
  public void Read() throws Exception {
	  	  Properties prop=new Properties();
	  	  prop.load(new FileInputStream(".//Constant.Property"));
	  	  driver.get(prop.getProperty("URL"));
	  	  driver.findElement(findType(prop.getProperty("e_xpath"))).click();
	  	  Thread.sleep(2000);
  }
  
  public By findType(String value)
  {
	  By b=null;
	  if(value.endsWith("_linktext"))
		  b=By.linkText(value.split("_")[0]);
	  else if(value.endsWith("_xpath"))
		  b=By.xpath(value.split("_")[0]);
		  
	  return b;
  }
}
