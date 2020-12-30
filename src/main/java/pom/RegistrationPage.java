package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

	public WebDriver driver;

//=======================Locators=========================================

	By clickregister = By.xpath("//a[normalize-space()='Register']");
	By gender = By.xpath("//input[@id='gender-male']");
	By firstName = By.xpath("//input[@id='FirstName']");
	By lastName = By.xpath("//input[@id='LastName']");
	By email = By.xpath("//input[@id='Email']");
	By password = By.xpath("//input[@id='Password']");
	By confirmpassword = By.xpath("//input[@id='ConfirmPassword']");
	By btnregister = By.xpath("//input[@id='register-button']");

//=======================Locators=========================================

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getGender() {

		return driver.findElement(gender);
	}

	public WebElement getfirstName() {

		return driver.findElement(firstName);
	}

	public WebElement getlastName() {

		return driver.findElement(lastName);
	}

	public WebElement getEmail() {

		return driver.findElement(email);
	}

	public WebElement getpassword() {

		return driver.findElement(password);
	}

	public WebElement getconfirmpassword() {

		return driver.findElement(confirmpassword);
	}

	public WebElement Clickbtnregister() {

		return driver.findElement(btnregister);
	}

	public WebElement getClickRegister() {

		return driver.findElement(clickregister);

	}
}