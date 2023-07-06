package mainjava2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage2 extends BaseClass2 {

	// All the locators of page //

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement txtDashboard;

	@FindBy(css = ".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon")
	private WebElement logoutDropDownClick;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButtonClick;

	// Initialization of locators/variables //

	public DashBoardPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods required to perform test steps //
	/**
	 * @Author : Aniket Kharde
	 * @Date : 07-Feb-2023
	 * @Description : This test method used to get Dashboard page title
	 * @return String
	 */
	public String getDashBoardPageTitle() {
		return txtDashboard.getText();
	}

	/**
	 * @Author : Aniket Kharde
	 * @Date : 07-Feb-2023
	 * @Description : This test method used to Logout
	 */
	public void clickLogoutButton() {
		logoutDropDownClick.click();
		logoutButtonClick.click();
	}
}
