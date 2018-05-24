package orangehrm_automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import orangehrm_automation.PageObject;

public class ConfirmationDialog extends PageObject {
	
	@FindBy(how = How.ID, using = "dialogDeleteBtn")	 
	private WebElement okButton;
	
	public ConfirmationDialog(WebDriver driver) {
		super(driver);
	}

	public void confirm() {		
		okButton.click();
	}
	
}
