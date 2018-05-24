package orangehrm_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import entities.Employee;
import orangehrm_automation.common.ConfirmationDialog;

public class EmployeeInformationPage extends PageObject {

	@FindBy(how = How.ID, using = "btnDelete")	 
	private WebElement deleteButton;
	
	public EmployeeInformationPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isEmployeePresentInTable(Employee employee) {		
		String firstAndMiddleName = employee.getFirstName() + " " + employee.getMiddleName();
		String employeeSelector = "//table//td[a[text() = '" + firstAndMiddleName + "']]/following-sibling::td[a[text() = '" + employee.getLastName() + "']]"; 
		boolean isEmployeeEntryDisplayedInTable = driver.findElement(By.xpath(employeeSelector)).isDisplayed();
		return isEmployeeEntryDisplayedInTable;
	}
	
	public EmployeeInformationPage  deleteEmployee(Employee employee) {		
		String firstAndMiddleName = employee.getFirstName() + " " + employee.getMiddleName();
		String employeeSelector = "//tr[td[a[text() = '" + firstAndMiddleName + "']]/following-sibling::td[a[text() = '" + employee.getLastName() + "']]]"; 
		boolean isEmployeeEntryDisplayedInTable = driver.findElement(By.xpath(employeeSelector)).isDisplayed();
		if (isEmployeeEntryDisplayedInTable) {			
			WebElement employeeRow= driver.findElement(By.xpath(employeeSelector));
			employeeRow.findElement(By.tagName("input")).click();
			deleteButton.click();
			ConfirmationDialog confirmationDialog = PageFactory.initElements(driver, ConfirmationDialog.class);
			confirmationDialog.confirm();
		}
		
		return this;
	}
}
