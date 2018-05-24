package orangehrm_automation;

import org.openqa.selenium.WebDriver;

import orangehrm_automation.common.AdminBar;

public class DashboardPage extends PageObject {

	public AdminBar adminBar = new AdminBar(driver);
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}	
}
