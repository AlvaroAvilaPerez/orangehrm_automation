package orange_tests;

import org.testng.annotations.Test;

import entities.Employee;
import orangehrm_automation.EmployeeInformationPage;
import orangehrm_automation.LoginPage;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class EmployeeTest extends BaseTest {
	protected Employee employee;
	protected LoginPage loginPage;
	protected EmployeeInformationPage employeeInformationPage;
	
	public EmployeeTest() {
		employee = new Employee("Purple", "Hrm", "Automation");
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		employeeInformationPage = PageFactory.initElements(driver, EmployeeInformationPage.class);
	}
	
	@Test
	public void verifyEmployeeCreation() throws InterruptedException {
		
		boolean isEmployeePresentInTable = loginPage.loginWithCredentials("Admin", "admin")
		.adminBar.clickOnPIMTab()
		.clickOnPIMAddEmployee()
		.addEmployee(employee)
		.adminBar.clickOnPimEmployeeListTab()
		.isEmployeePresentInTable(employee);
		
		// Verify that Employee has been added to Employee information table
		assertTrue(isEmployeePresentInTable);		
	}
	
	@BeforeTest
	public void beforeTest() {
		loginPage.goTo();
		
		// Verify that Login page is loaded
		assertTrue(loginPage.isInitialized());
		
	}

	@AfterTest
	public void afterTest() {
		employeeInformationPage.deleteEmployee(employee);
    	driver.quit();
	}
}
