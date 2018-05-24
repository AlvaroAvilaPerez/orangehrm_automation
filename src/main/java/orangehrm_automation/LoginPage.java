package orangehrm_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {
	
	protected String pageUrl = "http://opensource.demo.orangehrmlive.com/index.php/auth/login"; 
	
	@FindBy(how = How.ID, using = "txtUsername")	 
	private WebElement userName;
	
	@FindBy(how = How.ID, using = "txtPassword")	 
	private WebElement userPassword;
	
	@FindBy(how = How.ID, using = "btnLogin")	 
	private WebElement submit;		
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public DashboardPage loginWithCredentials(String userAccountName, String userAccountPassword){		
		userName.clear();
		userName.sendKeys(userAccountName);
		userPassword.clear();
		userPassword.sendKeys(userAccountPassword);
		submit.click();
		
		return PageFactory.initElements(driver, DashboardPage.class);
	}
	
	public boolean isInitialized() {
		return userName.isDisplayed() && userPassword.isDisplayed();
	}
	
	public void goTo() {
		driver.get(pageUrl);
	}
}
