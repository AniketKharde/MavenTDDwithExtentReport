package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import mainjava2.BaseClass2;
import test2.BaseTest2;

public class ScreenshotUtility extends BaseTest2 {

	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot scrnshot = (TakesScreenshot) driver;
		File source = scrnshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png");
		FileHandler.copy(source, destination);
		// FileUtils.copyFile(source, destination); // not available from selenium 3.9 and above 
		// we need to add commons-io dependency //
		return System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png";
	}

}
