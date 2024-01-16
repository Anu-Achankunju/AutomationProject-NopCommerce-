package com.nopcommerce.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
	WebDriver driver;
	public AddToCartPage(WebDriver rdriver) {
		driver=rdriver;
	}
	By quantity= By.xpath("//*[@id=\"product_enteredQuantity_4\"]");
	
	
	public void enterQuantity(String number) {
		driver.findElement(quantity).sendKeys(number);
	}
}
