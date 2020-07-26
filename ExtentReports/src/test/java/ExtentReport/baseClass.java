package ExtentReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.utils.FileUtil;

import TestNgListeners.TestNGlisteners;

public class baseClass extends TestNGlisteners{

	
	private final static String filePath = System.getProperty("user.dir") + 
			"/src/main/resources/data.properties";
	
	static FileInputStream fs;
	
	public static Properties prop;
	
	public static WebDriver driver;
	
	public static ExtentReports extent = ExtentReporter.createInstance();
	
	//constructor for initialising properties file
	public baseClass() throws IOException {
		
		try {
			fs = new FileInputStream(new File(filePath));
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fs);
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
