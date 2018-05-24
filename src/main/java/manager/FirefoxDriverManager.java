package manager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class FirefoxDriverManager extends DriverManager{
	private GeckoDriverService geckoService;

    @Override
    public void startService() {
    	String driverFolder = "driver";
    	Path currentPath = Paths.get(System.getProperty("user.dir"));
    	Path firefoxDriverPath = Paths.get(currentPath.toString(), driverFolder, "geckodriver.exe");		
    	if (geckoService == null) {
    		try {
    			geckoService = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File(firefoxDriverPath.toString()))
                    .usingAnyFreePort()
                    .build();
    			geckoService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
    	if (geckoService.isRunning()) {
    		geckoService.stop();
    	}
    }

    @Override
    public void createDriver() {    	
        driver = new FirefoxDriver(geckoService);
    }
}
