package TESTING.E2EProject;

import java.io.IOException;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.LogoutPage;
import pom.RegistrationPage;
import resources.Base;

public class TC_01_Registration extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;

	@BeforeTest
	public void getdriver() throws IOException {

		driver = initializedriver();
		log.info("driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("url got opened");

	}

	@Test(dataProvider = "regdetails")
	public void baseRegistration(String firstName, String lastName, String lpassword, String cpassword)
			throws InterruptedException {

		RegistrationPage rp = new RegistrationPage(driver);
		LogoutPage lp = new LogoutPage(driver);

		String randomEmail = randomEmail();

		rp.getClickRegister().click();
		rp.getGender().click();
		rp.getfirstName().sendKeys(firstName);
		rp.getlastName().sendKeys(lastName);
		rp.getEmail().sendKeys(randomEmail);
		rp.getpassword().sendKeys(lpassword);
		rp.getconfirmpassword().sendKeys(cpassword);
		
		rp.Clickbtnregister().click();
		lp.getClicklogout().click();

		Thread.sleep(5000);

		log.info("All the users got registered");

	}

	@DataProvider(name = "regdetails")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Ramesh", "Singh", "Qwerty@123", "Qwerty@123" },
				{ "Saurabh", "Sharma", "Qwerty@123", "Qwerty@123" },
				{ "Bhupesh", "Bhatia", "Qwerty@123", "Qwerty@123" } };

	}

	@AfterTest

	public void tearDown() {

		driver.close();
		log.info("Browser got closed, Testcase_Tc_01 got passed");
	}

	public String randomEmail() {

		return "random-" + UUID.randomUUID().toString() + "@example.com";

	}

}
