package com.tests;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginMap {
 
	public static WebDriver driver;
	String URl = "";
	String username ="";
	String password ="";
	
	
	public LoginMap(String Url,String username,String password) {
		
		this.URl= Url;
		this.username= username;
		this.password = password;
	}
	
	@BeforeTest
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("");
		
		HashMap<String,LoginMap> loginCredentials = new HashMap<String,LoginMap>();
		
		LoginMap Test_Env = new LoginMap("");
		LoginMap Stage_Env = new LoginMap("");
		
		//Adding details to map
		loginCredentials.put("TestEnv", Test_Env);
		loginCredentials.put("StageEnv", Stage_Env);
		
		for(Entry<String, LoginMap> entry:loginCredentials.entrySet()) {
			
			String key = entry.getKey();
			LoginMap h = entry.getValue();
			
			System.out.println(key +"Details");
			System.out.println(h.URl +" \n"+"Username :" +h.username +" \n"+"Password:"+h.password);
		
	}
	}
	//loginData 
//	public static  HashMap<String, LoginMap> loginData(){
//		
//		HashMap<String,LoginMap> loginCredentials = new HashMap<String,LoginMap>();
//		
//		LoginMap Test_Env = new LoginMap("");
//		LoginMap Stage_Env = new LoginMap("");
//		
//		//Adding details to map
//		loginData().put("Test", Test_Env);
//		loginData().put("StageEnv", Stage_Env);
//		
//			String key = entry.getKey();
//		for(Entry<String, LoginMap> entry:loginCredentials.entrySet()) {
//			
//			LoginMap h = entry.getValue();
//			
//			System.out.println(key +"Details");
//			System.out.println(h.URl +" " + h.username+" "+h.password);
//			
//		}
//		
//		return loginCredentials;
//	}
}
