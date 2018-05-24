package orangehrm_automation;

import org.openqa.selenium.WebDriver;

import orangehrm_automation.common.AdminBar;

public class PersonalDetailsPage extends PageObject{
	
	public AdminBar adminBar = new AdminBar(driver);
	
	public PersonalDetailsPage(WebDriver driver) {
		super(driver);	
	}	
}
