package testNG_Day2;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AllAnotation {
  @Test
  public void f() {
	  System.out.println("In test1");
  }
  
  @Test
  public void f2() {
	  System.out.println("In test 2");
  }
  @BeforeMethod
  public void beforeMethod() {
System.out.println("In before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("In after method");
  }
  

  @BeforeClass
  public void beforeClass() {
	  System.out.println("In before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("In after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("In before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("In after Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("In before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("In after Suite");
  }

}
