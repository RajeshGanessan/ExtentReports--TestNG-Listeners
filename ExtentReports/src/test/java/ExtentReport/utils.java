package ExtentReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utils extends baseClass {

	public utils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Screenshot
//	public static String takeScreenshot() throws Exception {
//		
//		File scshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir")+ "/Reports/Screenshots/"+ System.currentTimeMillis()+".png";
//		
//		System.out.println(path);
//		FileUtils.copyFile(scshot, new File(path));
//		    
//		return path;
//	}

}
