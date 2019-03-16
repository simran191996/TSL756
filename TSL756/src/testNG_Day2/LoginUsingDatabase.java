package testNG_Day2;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LoginUsingDatabase {
	WebDriver driver;
	java.sql.Connection conn;

	@Test(dataProvider = "dp")
	public void Login(String UN, String PW) {
		LoginDataDaoImpl loginImpl=new LoginDataDaoImpl();
		LoginPojo log= new LoginPojo();

		driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:16954781911278626555::NO:::");
		driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).clear();
		driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).sendKeys(UN);
		driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).clear();
		driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).sendKeys(PW);
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
		if(driver.getTitle().equals("Oracle"))
		{
			loginImpl.insertStatus(UN, "test pass");
		}
		else 
		{
			loginImpl.insertStatus(UN, "test fail");
		}
		
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.partialLinkText("Log")).click();
	}

	@DataProvider
	public Object[][] dp() {
		Object[][] data = new Object[4][2];

		LoginDataDaoImpl loginImpl = new LoginDataDaoImpl();
		List<LoginPojo> loginList = loginImpl.getAllLoginDetails();
		Iterator<LoginPojo> loginItr = loginList.iterator();
		int i = 0;
		while (loginItr.hasNext()) {

			LoginPojo log = loginItr.next();

			System.out.println("userName is:" + log.getUserName());
			System.out.println("PassWord is:" + log.getPassWord());
			System.out.println("Status is:" + log.getStatus());
			System.out.println("======================================");

			data[i][0] = log.getUserName();
			data[i][1] = log.getPassWord();
			// data[i][2]=log.getStatus();
			i++;
				}

		return data;
	}

	@BeforeTest
	public void beforeTest() {
		driver = BrowserSetup.browserStart("chrome");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

/*	@AfterMethod
	public void AfterMethod(ITestResult result) {

		System.out.println(ITestResult.FAILURE);
		System.out.println(ITestResult.SUCCESS);


		LoginDataDaoImpl loginImpl=new LoginDataDaoImpl();
		LoginPojo log= new LoginPojo();
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			
			System.out.println(log.getUserName()+"-------------------------------------------");
			loginImpl.insertStatus(log.getUserName(), "test pass");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			loginImpl.insertStatus(log.getUserName(), "test fail");
		}
		{
			loginImpl.insertStatus(log.getUserName(), "test pass");
		}

	}*/

}
