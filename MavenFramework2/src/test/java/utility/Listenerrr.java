package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listenerrr extends ScreenshotUtility implements ITestListener {

//	ExtentReports extent = CustomReporterrr.extentReporterGenrator();
	ExtentReports extent = CustomReporterrr2.extentReporterGenrator();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {   // ITestResult is class
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String filepath = null;

		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test is Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
