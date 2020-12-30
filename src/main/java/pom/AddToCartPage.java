package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {

	public WebDriver driver;

	// =======================Locators=========================================

	By login = By.xpath("//a[normalize-space()='Log in']");
	By shopbooks = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']");
	By additem = By.xpath("//div[@class='master-wrapper-content']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]");
	By shoppingcart = By.xpath("//a[normalize-space()='shopping cart']");
	By terms = By.xpath("//input[@id='termsofservice']");
	By checkout = By.xpath("//button[normalize-space()='Checkout']");
	By amountotal = By.xpath("//span[@class='product-price order-total']//strong[contains(text(),'10.00')]");

	// =======================Locators=========================================

	public AddToCartPage(WebDriver driver) {

		this.driver = driver;
	}

	public LoginPage getlogin() {

		driver.findElement(login).click();
		LoginPage l = new LoginPage(driver); // creating object of loginPage and directly using in test case TC_03

		return l;

	}

	public WebElement getShopbooks() {

		return driver.findElement(shopbooks);
	}

	public WebElement getadditem() {

		return driver.findElement(additem);
	}

	public WebElement getshoppingcart() {

		return driver.findElement(shoppingcart);
	}

	public WebElement getterms() {

		return driver.findElement(terms);
	}

	public WebElement getcheckout() {

		return driver.findElement(checkout);
	}

	public WebElement getamountTotal() {

		return driver.findElement(amountotal);
	}
}
