package TESTING.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.AddToCartPage;
import pom.LoginPage;
import resources.Base;

public class TC_03_AddToCart extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void getdriver() throws IOException {

		driver = initializedriver();
		log.info("driver got intialized");
		driver.get(prop.getProperty("url"));
		log.info("url got opened");
	}

	@Test
	public void baseAddToCart() throws InterruptedException {

		AddToCartPage cart1 = new AddToCartPage(driver);

		LoginPage lp = cart1.getlogin();

		lp.getusername().sendKeys("gaurav10690@gmail.com");
		lp.getpassword().sendKeys("Qwerty@123");

		cart1.getShopbooks().click();
		cart1.getadditem().click();
		cart1.getshoppingcart().click();
		cart1.getterms().click();

		Thread.sleep(5000);

		String amountvalidation = cart1.getamountTotal().getText();

		Assert.assertEquals(amountvalidation, "10.00");
		cart1.getcheckout().click();
		log.info("Amount got validated");

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		log.info("Browser got closed, Testcase_Tc_03 got passed");
	}

}
