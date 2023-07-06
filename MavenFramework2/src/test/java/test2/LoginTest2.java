package test2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.cj.protocol.Resultset;

import utility.DatabaseUtility;
import utility.ExcelUtility;

public class LoginTest2 extends BaseTest2 {

	@Test(priority = 0, groups = { "Smoke", "Regression" })
	public void verifyTitleOfBuild() {
		String verifyBuildTitle = loginpage.getBuildTitle();
		Assert.assertEquals(verifyBuildTitle, "OrangeHRM");
	}

	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public void verifyTitleofPage() {
		String verifyPageTitle = loginpage.getPageTitle();
		Assert.assertEquals(verifyPageTitle, "Login");
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" })
	public void verifyCurrentUrlofPage() {
		String verifyUrlofPage = loginpage.getPageUrl();
		Assert.assertEquals(verifyUrlofPage, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	/*@Test(priority = 3, groups = { "Smoke", "Regression" })
	public void verifyLoginWithCorrectCredentials() {
		loginpage.setUsername("Admin");
		loginpage.setPassword("admin123");
		loginpage.clickLoginButton();
		String verifydashTitle = dashboardpage.getDashBoardPageTitle();
		Assert.assertEquals(verifydashTitle, "Dashboard");
	}*/

	@Test(priority = 3, groups = { "Smoke", "Regression" },dataProvider="LoginData")
	public void verifyLoginWithCorrectCredentials(String user ,String pass) {
		loginpage.setUsername(user);
		loginpage.setPassword(pass);
		loginpage.clickLoginButton();
		String verifydashTitle = dashboardpage.getDashBoardPageTitle();
		Assert.assertEquals(verifydashTitle, "Dashboard");
	}
	
	// excel data //
	/*@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		Object[][] data = ExcelUtility.getTestData("LoginData");
		return data;
	}*/
	
	//Database data //
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException, SQLException{
		Object[][] data = DatabaseUtility.getDatabaseData("Login_Data");
		return data;
	}
	
	 
}
