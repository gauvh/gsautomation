package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializedriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		if (browserName.equals("IE")) {

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		
		
TakesScreenshot ts=(TakesScreenshot) driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileHandler.copy(source, new File(destinationFile));
	
	return destinationFile;
	}

}
