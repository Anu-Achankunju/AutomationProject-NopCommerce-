package com.nopcommerce.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver rdriver) {
		driver=rdriver;
	}
	By loginEmailId= By.id("Email");
	By loginPassword= By.id("Password");
	By clickLoginButton= By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
	By errorMessageLocator=By.xpath("//div[contains(@class,'message-error validation-summary-errors')]");
	public void enterLoginDetails(String emailid ,String password) {
		driver.findElement(loginEmailId).sendKeys(emailid);
		driver.findElement(loginPassword).sendKeys(password);
		
	}
	public void clickLogin() {
		driver.findElement(clickLoginButton).click();
		
		
	}
	 public boolean isErrorMessageDisplayed() {
	        
			return driver.findElement(errorMessageLocator).isDisplayed();
	    }
}
