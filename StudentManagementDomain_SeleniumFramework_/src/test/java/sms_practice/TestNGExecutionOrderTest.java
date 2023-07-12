package sms_practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGExecutionOrderTest {
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before Method");
	}
	
	@BeforeMethod
	public void beforeMethod2(){
		System.out.println("Before Method2");
	}
	
	@Test(priority = 1)
	public void movie1Test(){
		System.out.println("Thuppakki");
       	
	}
	
	@Test(priority = -1,invocationCount = 2,dependsOnMethods = "movie1Test")
	public void movie2Test(){
		System.out.println("Kaithi");
		Assert.fail();
	}
	
	@AfterMethod	
	public void afterMethod(){
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("After Class");
	}

	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}

	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
	}
}

