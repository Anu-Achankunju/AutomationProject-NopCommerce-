package com.nopcommerce.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.page.HomePage;
import com.nopcommerce.page.LoginPage;
import com.nopcommerce.page.SearchButtonPage;

public class TC_SearchButton extends BaseClass {
	@Test
	public void searchTc() {
		driver.get(urls);
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnLogin();
		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterLoginDetails("anu123@gmail.com", "Anu@12345");
        loginpage.clickLogin();
      
			
	SearchButtonPage srchbtn= new SearchButtonPage(driver);
	 
	srchbtn.enterSearchDetails("apple");
	srchbtn.searchCLick();
}
	@Test(priority=2)
	public void VerifySearchProduct() throws IOException 
	{
		String searchKey = "Apple";
//		HomePage homepage= new HomePage(driver);
//		homepage.clickOnLogin();


//		LoginPage loginpage = new LoginPage(driver);
//        loginpage.enterLoginDetails("anu123@gmail.com", "Anu@12345");
//        loginpage.clickLogin();

		
	SearchButtonPage srchbtn= new SearchButtonPage(driver);
	 
	srchbtn.enterSearchDetails("apple");
	srchbtn.searchCLick();
	
		

		String SearchResultProductname=srchbtn.getSearchResultProductName();



		if(SearchResultProductname.contains(searchKey))
		{
			System.out.println("Success");
			Assert.assertTrue(true);
			srchbtn.addToCartClick();


		}
		else
		{
			
			captureScreenShot(driver,"VerifySearchProduct");
			System.out.println("fail");
			Assert.assertTrue(false);

		} 
	}}
