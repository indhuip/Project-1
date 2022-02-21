package AppHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import com.driver.DriverFactory;
import com.qa.utilities.ConfigReader;

import io.cucumber.messages.types.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() throws IOException {
		
		configReader= new ConfigReader();
		prop= configReader.init_prop();
		
	}
	
	@Before(order=1)
	public void launchBrowser() throws IOException{
		
		String browserName= prop.getProperty("browser");
		driver= driverFactory.init_driver(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() throws IOException{
		
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) throws IOException{
		
		//take screenshot
		String screenshotName= scenario.getName().replaceAll(" ", "_");
		byte[] sourcePath=((TakesScreenshot).driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath,"image/png",screenshotName);
		
	}

}
