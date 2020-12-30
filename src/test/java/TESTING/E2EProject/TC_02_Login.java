package TESTING.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.LoginPage;
import resources.Base;

public class TC_02_Login extends Base {

	public WebDriver driver;
	public static Logger  log= LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void getdriver() throws IOException {

		driver = initializedriver();
		log.info("Browser got intialized");

		driver.get(prop.getProperty("url"));
		log.info("url opened");
	}

	@Test(dataProvider = "logindetails")

	public void baseLogin(String unm, String pwd) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);

		lp.getlogin().click();
		lp.getusername().sendKeys(unm);
		lp.getpassword().sendKeys(pwd);
		lp.getbtnlogin().click();
		
		log.info("User got logged-in");
		
	}

	@DataProvider(name = "logindetails")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "gaurav10690@gmail.com", "Qwerty@123" } };

	}

	@AfterTest

	public void tearDown() {

		driver.close();
		log.info("Browser got closed, Testcase_Tc_02 got passed");
	}

}
