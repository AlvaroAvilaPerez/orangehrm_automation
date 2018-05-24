package orangehrm_automation.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangehrm_automation.AddEmployeePage;
import orangehrm_automation.EmployeeInformationPage;
import orangehrm_automation.PageObject;

public class AdminBar extends PageObject{
	
	@FindBy(how = How.LINK_TEXT, using = "PIM")	 
	private WebElement pim;
	
	@FindBy(how = How.ID, using = "menu_pim_addEmployee")	 
	private WebElement pimAddEmployee;
		
	@FindBy(how = How.ID, using = "menu_pim_viewEmployeeList")	 
	private WebElement pimEmployeeListTab;
	
	public AdminBar(WebDriver driver) {
		super(driver);
	}
	
	public AdminBar clickOnPIMTab() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(pim));
		pim.click();		
		if (!driver.findElement(By.xpath("//parent::li")).getAttribute("class").equals("current")) {
			pim.click();			
		}
		
		return this;
	}
	
	public AddEmployeePage clickOnPIMAddEmployee() {		
		pimAddEmployee.click();
		return PageFactory.initElements(driver, AddEmployeePage.class);
	}
	
	public EmployeeInformationPage clickOnPimEmployeeListTab() {		
		pimEmployeeListTab.click();
		return PageFactory.initElements(driver, EmployeeInformationPage.class);
	}
	
}
