package orangehrm_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import entities.Employee;

public class AddEmployeePage extends PageObject{

	@FindBy(how = How.ID, using = "firstName")	 
	private WebElement firstEmployeeName;
	
	@FindBy(how = How.ID, using = "middleName")	 
	private WebElement middleEmployeeName;
		
	@FindBy(how = How.ID, using = "lastName")	 
	private WebElement lastEmployeeName;
	
	@FindBy(how = How.ID, using = "btnSave")	 
	private WebElement saveEmployee;
	
	public AddEmployeePage(WebDriver driver) {
		super(driver);
	}

	public PersonalDetailsPage addEmployee(Employee employee) {		
		firstEmployeeName.clear();
		firstEmployeeName.sendKeys(employee.getFirstName());
		middleEmployeeName.clear();
		middleEmployeeName.sendKeys(employee.getMiddleName());
		lastEmployeeName.clear();
		lastEmployeeName.sendKeys(employee.getLastName());
		saveEmployee.click();
		
		return PageFactory.initElements(driver, PersonalDetailsPage.class);
	}
	
}
