package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	// =======================Locators=========================================

	By login = By.xpath("//a[normalize-space()='Log in']");
	By usernamelogin = By.xpath("//input[@id='Email']");
	By passwordlogin = By.xpath("//input[@id='Password']");
	By btnlogin = By.xpath("//input[@value='Log in']");

	// =======================Locators=========================================

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getlogin() {

		return driver.findElement(login);

	}

	public WebElement getusername() {

		return driver.findElement(usernamelogin);
	}

	public WebElement getpassword() {

		return driver.findElement(passwordlogin);
	}

	public WebElement getbtnlogin() {

		return driver.findElement(btnlogin);
	}

}
