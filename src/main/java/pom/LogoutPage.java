package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	public WebDriver driver;

//=======================Locators=========================================
	By clicklogout = By.xpath("//a[normalize-space()='Log out']");

//=======================Locators=========================================	

	public LogoutPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getClicklogout() {

		return driver.findElement(clicklogout);
	}

}
