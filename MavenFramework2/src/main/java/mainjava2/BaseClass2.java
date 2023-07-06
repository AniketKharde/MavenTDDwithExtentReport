package mainjava2;

import org.openqa.selenium.WebDriver;

public abstract class BaseClass2 {

	public static WebDriver driver;  // remove static for parallel testing
	protected LoginPage2 loginpage; 
	protected DashBoardPage2 dashboardpage;
	protected PIMPage2 pimpage;
}
