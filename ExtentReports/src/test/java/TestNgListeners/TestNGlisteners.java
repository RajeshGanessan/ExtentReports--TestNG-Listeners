package TestNgListeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReport.ExtentReporter;
import ExtentReport.baseClass;
import ExtentReport.utils;

public class TestNGlisteners implements ITestListener {

	private static ExtentReports extent = ExtentReporter.createInstance();
	public static ExtentTest test;
	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Extent Report Generation has Started");
		ExtentTest test = extent.createTest(context.getName());
 
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Suite has been Ended");
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println(result.getMethod().getMethodName() + "Started");
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println(result.getMethod().getMethodName() + "Test case PASSED !");
		test.log(Status.PASS, "Test case Passed!");
		}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		String takeScreenshot = null;
		System.out.println(result.getMethod().getMethodName() +" Test Case FAILED !");
		
		test.log(Status.FAIL, "Test case Failed!");
		
//		try {
//			
//			takeScreenshot = utils.takeScreenshot();
//		} catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();	
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			test.get().addScreenCaptureFromPath(takeScreenshot);
//		} catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println(result.getMethod().getMethodName() +" Test Cases SKIPPED !");
		test.log(Status.SKIP, result.getMethod().getMethodName() + " Skipped !");
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}


}
