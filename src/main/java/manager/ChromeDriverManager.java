package manager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager{

	private ChromeDriverService chromeService;

    @Override
    public void startService() {
    	String driverFolder = "driver";
    	Path currentPath = Paths.get(System.getProperty("user.dir"));
    	Path chromeDriverPath = Paths.get(currentPath.toString(), driverFolder, "chromedriver.exe");		
        if (null == chromeService) {
            try {
                chromeService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(chromeDriverPath.toString()))
                    .usingAnyFreePort()
                    .build();
                chromeService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (chromeService != null && chromeService.isRunning())
            chromeService.stop();
    }

    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);        
        driver = new ChromeDriver(chromeService, options);
    }
}
