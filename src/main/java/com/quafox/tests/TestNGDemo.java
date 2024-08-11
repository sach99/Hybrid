package com.quafox.tests;

import org.testng.annotations.Test;

public class TestNGDemo {
	@Test (priority=1)
	public void F() {
		  System.out.println("1st Test Case");
	  }
	
  @Test (priority=3)
  public void A() {
	  System.out.println("2nd Test Case");
  }
  
  @Test (priority=0)
  public void T() {
	  System.out.println("3rd Test Case");
  }
  
  @Test(priority=2)
  public void B() {
	  System.out.println("4th Test Case");
  }
}
