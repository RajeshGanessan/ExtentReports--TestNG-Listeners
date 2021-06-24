package com.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNgListeners.TestNGlisteners;


@Listeners(TestNGlisteners.class																																																																																																																																																																																																																																																																																																																																																																																																																																												)
public class HashMapSelenium {

	
	public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		
		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("");
		
	}
	
	@Test(priority=1)
	public void Login() {
		
		
		String Test = loginData().get("Test");
		System.out.println(Test);
		
		driver.findElement(By.id("email")).sendKeys(Test.split(":")[0]);
		
		driver.findElement(By.id("password")).sendKeys(Test.split(":")[1]);
		
	}
		
	
	public static HashMap<String, String> loginData(){
		
		
		HashMap<String, String> loginCredentials = new HashMap<String,String>();
		
		loginCredentials.put("");
		loginCredentials.put("");
		
		
		
		return loginCredentials;
	}
}
