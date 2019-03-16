package testNg_Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SqlCommands {
	private WebDriver driver;
	public  SqlCommands(WebDriver driver) {
		this.driver=driver;
	}

	private By e_sqlcomm=By.xpath("//*[@title='SQL Commands']");
	void startsqlComm()
	{
		driver.findElement(e_sqlcomm).click();
	}
}
