package mainjava2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage2 extends BaseClass2 {

	// All the locators of page //
	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement clickPIMPage;

	@FindBy(css = "h6")
	private WebElement titleOfPIMPage;

	@FindBy(xpath = "//label[text()='Employee Name']//parent::div//following-sibling::div//input")
	private WebElement setEmpName;

	@FindBy(css = "button[type='submit']")
	private WebElement clickSearch;

	@FindBy(className = "orangehrm-container")
	private WebElement searchRecord;

	@FindBy(css = "button[type='reset']")
	private WebElement resetData;

	@FindBy(xpath = "//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']")
	private WebElement setEmpID;

	@FindBy(xpath = "//label[text()='Employment Status']//parent::div//following-sibling::div//i")
	private WebElement clickEmpStatusDropDown;

	@FindBy(css = ".oxd-select-text.oxd-select-text--active .oxd-select-text-input")
	private WebElement selectEmpStatus;

	// Initialization of locators/variables //
	public PIMPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods required to perform test steps //
	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to click PIM Page
	 */
	public void clickPIMPageLink() {
		clickPIMPage.click();
	}

	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to get title of PIM page
	 * @return : String
	 */
	public String getPIMPageTitle() {
		return titleOfPIMPage.getText();
	}

	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to set Employee name
	 * @param empName
	 */
	public void setEmployeeName(String empName) {
		setEmpName.sendKeys(empName);
	}

	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to click search button
	 */
	public void clickSearchButton() {
		clickSearch.click();
	}

	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to
	 * @param empName
	 * @return String
	 */
	public String getEmpListFromSearchResults(String empData) {
		return searchRecord.findElements(By.xpath("//div[contains(text(),'" + empData + "')]")).get(0).getText();
	}

	public void resetSearchData() {
		resetData.click();
	}

	public void setEmployeeID(String empID) {
		setEmpID.sendKeys(empID);
	}

	public void selectEmploymentStatus(String empStatus) {
		clickEmpStatusDropDown.click();
		// WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(5));
		// ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".oxd-select-dropdown.--position-bottom")));

		if (selectEmpStatus.getText().equals(empStatus)) {
			selectEmpStatus.click();
		}
	}
}
