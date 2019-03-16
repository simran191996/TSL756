package testNg_Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SqlHome {
	private WebDriver driver;
	
	public SqlHome(WebDriver driver) {
	
		this.driver = driver;
	}
	private By e_sql=By.xpath("//*[@title='SQL']");
	void startSql()
	{
		driver.findElement(e_sql).click();
	}
		
}
