package testNg_Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base;

public class DependsExample extends Base {
  @Test
  public void f1() {
	  System.out.println("In Test1");
	  Assert.assertTrue(true);
  }
  @Test(dependsOnMethods="f1")
  public void f2() {
	  System.out.println("In Test2");
	  Assert.assertEquals("LNT", "LNT");
  }
  @Test(dependsOnMethods="f2")
  public void f3() {
	  System.out.println("In Test3");
	  Assert.assertFalse(false);
	  }
}
