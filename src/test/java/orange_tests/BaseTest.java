package orange_tests;


import manager.DriverManager;
import manager.DriverManagerFactory;
import manager.DriverType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
	protected WebDriver driver;
	protected WebDriverWait wait;
    
	public BaseTest() {
		driver = driverManager.getDriver();
	}
	
    @BeforeClass
    public void setup() {    	
    	wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public void teardown () {
    }
}
