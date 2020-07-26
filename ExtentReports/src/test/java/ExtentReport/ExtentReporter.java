package ExtentReport;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter extends baseClass {

	
	public ExtentReporter() throws IOException {
		super();
	}

	static Calendar cal = Calendar.getInstance();
	static Date time = cal.getTime();
	
	
	private static ExtentReports extent;
	private static Platform platform;
    private static String reportFileName = "ExtentReports-Version3-Test-Automation-Report"+time+".html";
    private static String linuxPath = System.getProperty("user.dir")+ "/Reports";
    private static String windowsPath = System.getProperty("user.dir")+ "\\Reports";
    private static String linuxReportFileLoc = linuxPath + "/" + reportFileName;
    private static String winReportFileLoc = windowsPath + "\\" + reportFileName;
 
    public static ExtentReports getInstance() {
    	
    	if(extent == null) 
    		createInstance();
    		return extent;
    }
    
    //Creating extent report Instance
    public static ExtentReports createInstance() {
    platform = getPlatform();
    String fileName = getReportFileLocation(platform);
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
    htmlReporter.setAppendExisting(false);
    //htmlReporter.
    htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setDocumentTitle(fileName);
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName(fileName);
    
    extent = new ExtentReports();
//    extent.setSystemInfo("Testing Application URL",prop.getProperty("Testing_URL"));
//    extent.setSystemInfo("Browser Name",prop.getProperty("BrowserName"));

    extent.setSystemInfo("OS",System.getProperty("os.name"));
    extent.setSystemInfo("Host Name",System.getProperty("user.name"));
    extent.setSystemInfo("Java Version",System.getProperty("java.version"));
    
    extent.attachReporter(htmlReporter);
	return extent;

    }
    
    //Get current Platform
    private static Platform getPlatform() {
    	
    	if(platform == null) {
    		
    		String opSys = System.getProperty("os.name").toLowerCase();
    		if(opSys.contains("win")) {
    			platform = Platform.WINDOWS;
    		}
    		else if(opSys.contains("nix") || opSys.contains("nux")) {
    			platform = Platform.LINUX;
    		}
    		else if(opSys.contains("mac")) {
    			platform = Platform.MAC;
    		}
    			
    	}
    	
    	return platform;
    }
    
  //Select the extent report file location based on platform
    private static String getReportFileLocation (Platform platform) {
        String reportFileLocation = null;
        switch (platform) {
            case WINDOWS:
                reportFileLocation = winReportFileLoc;
                createReportPath(windowsPath);
                System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
                break;
            case LINUX:
            	reportFileLocation = linuxReportFileLoc;
            	createReportPath(linuxPath);
            	System.out.println("ExtentReport Path for Linux: " + linuxPath +"\n");
            	break;
            default:
                System.out.println("ExtentReport path has not been set! There is a problem!\n");
                break;
        }
        return reportFileLocation;
    }
    
    //Create the report path if it does not exist
    private static void createReportPath (String path) {
    	
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }
}
 