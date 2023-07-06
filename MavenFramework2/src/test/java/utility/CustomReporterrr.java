package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;

/*
 * @author Aniket Kharde
 * @date 2023-03-04
 * @description  
 */

public class CustomReporterrr {

	public static ExtentReports extent;

	public static ExtentReports extentReporterGenrator() {
		String path = System.getProperty("user.dir") + "\\Reports\\MavenExtentReport.html";
		/*
		 * ExtentHtmlReporter reporter =new ExtentHtmlReporter(path); //suitable for old ExtentReports version like 3 and 4//preferred 3.1.5
		 * reporter.config().setReportName("Regression Test Report");
		 * reporter.config().setDocumentTitle("OrangeHRM Build Report");
		 * reporter.config().setTheme(Theme.DARK);
		 * reporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy, hh:mm a'('zzz')'");
		 *                                    //        04.10.2023 7:36:32 PM
		 * extent = new ExtentReports();   
		 * extent.setSystemInfo("OS", "Windows");
		 * extent.setSystemInfo("Browser", "Chrome"); 
		 * extent.setSystemInfo("Org","Sequentia"); 
		 * extent.setSystemInfo("Tester", "Aniket Kharde");
		 * extent.attachReporter(reporter);
		 */

		return extent;
	}

}
