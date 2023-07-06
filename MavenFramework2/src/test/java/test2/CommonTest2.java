package test2;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class CommonTest2 extends BaseTest2 {

	@BeforeClass(groups = { "Smoke", "Regression" })
	public void login() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage.setUsername("Admin");
		loginpage.setPassword("admin123");
		loginpage.clickLoginButton();
		String verifydashTitle = dashboardpage.getDashBoardPageTitle();
		Assert.assertEquals(verifydashTitle, "Dashboard");
	}

}
