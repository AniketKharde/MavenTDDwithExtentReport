package mainjava2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 extends BaseClass2 {

	// All the locators of page // PageFactory/Object repository
	@FindBy(xpath = "//h5[text()='Login']")
	private WebElement txtLoginPage;

	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement passWord;

	@FindBy(tagName = "button")
	private WebElement clickButton;

	
	// Initialization of locators/variables/Page objects //
	public LoginPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);  //this means current class objects...it will initialize all the variables with driver
	}
	

	//Actions Methods required to perform test steps //
	/**
	 * @Author : Aniket Kharde
	 * @Date : 04-Feb-2023
	 * @Description : This test method used to get the Title of build
	 * @return : String
	 */
	public String getBuildTitle() {
		return driver.getTitle();
	}

	/**
	 * @Author : Aniket Kharde
	 * @Date : 04-Feb-2023
	 * @Description : This test method used to verify Title of login page
	 * @return : String
	 */
	public String getPageTitle() {
		return txtLoginPage.getText();
	}

	/**
	 * @Author : Aniket Kharde
	 * @Date : 04-Feb-2023
	 * @Description : This test method used to verify current Url of page
	 * @return : String
	 */
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * @Author : Aniket Kharde
	 * @Date : 04-Feb-2023
	 * @Description : This test method used to set username value
	 */
	public void setUsername(String usrname) {
		userName.sendKeys(usrname);
	}

	/**
	 * @Author : Aniket Kharde
	 * @Date : 04-Feb-2023
	 * @Description : This test method used to set password value
	 */
	public void setPassword(String pass) {
		passWord.sendKeys(pass);
	}

	/**
	 * @return
	 * @Author : Aniket Kharde
	 * @Date : 04-Feb-2023
	 * @Description : This test method used to click login button
	 */
	public void clickLoginButton() {
		clickButton.click();

	}

}
