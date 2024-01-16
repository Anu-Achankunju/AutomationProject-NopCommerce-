package com.nopcommerce.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver rdriver) {
		driver=rdriver;
	}
	By LoginLink= By.linkText("Log in");
	By RegisterLink= By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
 By logout= By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
	public void clickOnLogin() {
		driver.findElement(LoginLink).click();
	}
	public void clickOnRegister() {
		driver.findElement(RegisterLink).click();
	}
	public void clickOnLogout() {
		driver.findElement(logout).click();
	}
	
}
