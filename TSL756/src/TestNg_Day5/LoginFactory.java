package TestNg_Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory 
{
private WebDriver driver;
LoginFactory(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(name="p_t01")WebElement e_username;
@FindBy(name="p_t02")WebElement e_password;
@FindBy(xpath="//*[@value='Login']")WebElement e_Login;

public void LoginProcess(String UN,String PWD)
{
	e_username.sendKeys(UN);
	e_password.sendKeys(PWD);
	e_Login.click();
	
}
}
