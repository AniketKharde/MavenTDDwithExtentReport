package test2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava2.BaseClass2;
import mainjava2.DashBoardPage2;
import mainjava2.LoginPage2;
import mainjava2.PIMPage2;


public class BaseTest2 extends BaseClass2 {

	
	/*  @BeforeSuite(alwaysRun=true) 
	  public void initBrowser(){
	  WebDriverManager.chromedriver().setup(); 
	  ChromeOptions options= new ChromeOptions(); 
	  options.addArguments("--start-maximized"); // open Chromeurl in maximize screen // 
	//  options.addArguments("--incognito"); // open chrome in incognito mode // 
	//  options.addArguments("--headless"); // Execution without Visual UI of build running on screen //
	//  options.addArguments("--disable-extentions"); // disable existing extentions while launching // 
	//  options.addArguments("--disable-popup-blocking"); //disable pop-up on launching //
	//  options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // to disable chrome is controlled by automation tester // 
	//  DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); 
	//  desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
	  driver = new ChromeDriver(options); 
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); } */
	 

	@BeforeSuite(alwaysRun = true)   // use @BeforeTest for parallel testing
	public void initBrowser() throws IOException {
		// Properties class
		Properties prop = new Properties();
		// FileInputStream fileDestination = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\Maven\\MavenFramework\\src\\test\\java\\GlobalData.properties");
		FileInputStream fileDestination = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\GlobalData.properties");
		prop.load(fileDestination);
		// if cmd command contains browser name then it will execute that browser otherwise it use GlobalData.properties browser //
		// for cmd command --->mvn test -Dbrowsername //
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser"): prop.getProperty("browser");
		// String browserName = prop.getProperty("browser"); // for GlobalData.properties only
		if (browserName.contains("chrome")) { // To run chrome in normal mode-->// mvn test -Dchrome // for .properties file --> browser=chrome //
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) { // headless mode
				options.addArguments("--headless"); // To run in headless mode--> // mvn test -Dchromeheadless // for .properties file --> browser=chromeheadless //
			}
			driver = new ChromeDriver(options);
		} 
		else if (browserName.contains("edge")) {
			EdgeOptions options = new EdgeOptions();
		//	WebDriverManager.edgedriver().setup();
			if (browserName.contains("headless")) { // headless mode
				options.addArguments("--headless"); // To run in headless mode--> // mvn test -Dedgeheadless // for .properties file --> browser=edgeheadless //
			}
			driver = new EdgeDriver(options);
		} 
		else if (browserName.contains("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			if (browserName.contains("headless")) { // headless mode
				options.addArguments("--headless"); // To run in headless mode--> // mvn test -Dfirefoxheadless // for .properties file --> browser=firefoxheadless //
			}
			driver = new FirefoxDriver(options);
		}
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	

	@BeforeClass(groups = { "Smoke", "Regression" })
	public void pageObjects() {
		loginpage = new LoginPage2(driver);
		dashboardpage = new DashBoardPage2(driver);
		pimpage = new PIMPage2(driver);
	}

	@AfterSuite(alwaysRun = true)   // use @AfterTest for parallel testing
	public void tearDownEnvironment() {
		driver.quit();
	}

	@AfterClass(groups = { "Smoke", "Regression" })
	public void logOut() {
		dashboardpage.clickLogoutButton();
	}
}
