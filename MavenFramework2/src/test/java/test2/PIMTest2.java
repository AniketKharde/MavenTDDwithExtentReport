package test2;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import analyzer.RetryAnalyzer;
import utility.DatabaseUtility;
import utility.ExcelUtility;

public class PIMTest2 extends CommonTest2 {

	@Test(priority = 4, groups = { "Smoke", "Regression" })
	public void verifyTitleOfPIMPage() {
		pimpage.clickPIMPageLink();
		String verifyPIMPageTitle = pimpage.getPIMPageTitle();
		Assert.assertEquals(verifyPIMPageTitle, "PIM");
	}

	@Test(priority = 5, dataProvider = "EmpNameData", groups = { "Regression" })
	public void verifyEmpSearchEmpName(String eName) {
		pimpage.setEmployeeName(eName);
		pimpage.clickSearchButton();
		String verifyEmpName = pimpage.getEmpListFromSearchResults(eName);
		Assert.assertEquals(verifyEmpName, eName);
		pimpage.resetSearchData();
		driver.navigate().refresh();
	}

	/*@DataProvider
	public String[][] getData() {
		return new String[][] { { "Cassidy" }, { "Hope" }, { "Charlie" } };
	}
	*/
	/*@DataProvider
	public String[][] getData(){
		String[][] empNameData = {
				               {"Cassidy"},
				               {"Hope"},
				               {"Charlie"}               
		                    };
		return empNameData;
	}
	*/
	// excel data //
	/*@DataProvider(name="EmpNameData")
	public Object[][] getEmpNameData() throws IOException {
		Object[][] data = ExcelUtility.getTestData("PIMData");
		return data;
	}*/
	
	// Database data //
	@DataProvider(name="EmpNameData")
	public Object[][] getEmpNameData() throws SQLException{
		Object[][] data = DatabaseUtility.getDatabaseData("EmpName");
		return data;
	}

	@Test(priority = 6, groups = { "Regression" })
	public void verifyEmpSearchEmpID() {
		pimpage.setEmployeeID("0046");
		pimpage.clickSearchButton();
		String verifyEmpID = pimpage.getEmpListFromSearchResults("0046");
		Assert.assertEquals(verifyEmpID, "0046");
		pimpage.resetSearchData();
		driver.navigate().refresh();
	}

	@Test(priority = 7, groups = { "Regression" })
	public void verifyEmploymentStatus() {
		pimpage.selectEmploymentStatus("Full Time Employee");
		pimpage.clickSearchButton();
		String verifyStatus = pimpage.getEmpListFromSearchResults("Full Time Employee");
		Assert.assertEquals(verifyStatus, "Full Time Employee");
	}

}
