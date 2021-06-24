	package com.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReport.baseClass;
import TestNgListeners.TestNGlisteners;


@Listeners(TestNGlisteners.class)
public class LoginTest  extends baseClass {
	
	
	//public ExtentTest test;
	
	public LoginTest() throws IOException {
		super();
		
	
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	
	
	@BeforeMethod
	public void Init() {
		
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("");	
	}
	
	@Test(priority=1)
	public void VerifyTitleTest() {

		extent.createTest("Login");
		String title = driver.getTitle();
		System.out.println(title);                           
		Assert.assertEquals(title, "");
	test.log(Status.PASS, "title verified");
	}
//	
//	@Test(priority=2
//	public void logging_In() {
//		
//		String Email = "";
//		String password = "";
//		
//		driver.findElement(By.id("email")).sendKeys(Email);
//		test1.get().info("Entered Email as " + Email);
//		driver.findElement(By.id("password")).sendKeys(password);
//		test1.get().info("Entered password as " + password);
//		driver.findElement(By.id("sign_in_button")).click();
//		test1.get().info("Clicked Login Button");
//	}
	
	
	@AfterMethod
	public void tearDown() {		
		
		driver.quit();
	}
}
