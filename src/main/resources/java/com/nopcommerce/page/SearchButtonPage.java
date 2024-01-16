package com.nopcommerce.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchButtonPage {
	WebDriver driver;
	public SearchButtonPage(WebDriver rdriver) {
		driver=rdriver;
	}

	By searchButton= By.xpath("//*[@id=\"small-searchterms\"]");
	By searchButtonClick = By.xpath("//button[text()='Search']");
	By getSearchDetails= By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/h2/a");
	By  addToCart = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]");

	public void enterSearchDetails(String searchName) {
		WebElement searchInput = driver.findElement(searchButton);
		searchInput.clear();
		searchInput.sendKeys(searchName);
	}

	public void searchCLick() {
		driver.findElement(searchButtonClick).click();
	}
	public String getSearchResultProductName()
	{
		WebElement getSearchInput = driver.findElement(getSearchDetails);
		String anu= getSearchInput.getText();
		return anu;

	}
	public void addToCartClick() {
		driver.findElement(addToCart).click();
	}

}
