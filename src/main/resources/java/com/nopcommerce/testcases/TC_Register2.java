package com.nopcommerce.testcases;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nopcommerce.page.HomePage;
import com.nopcommerce.page.RegisterPage;
import com.nopcommerce.utilities.ExcelUtilities;


public class TC_Register2 extends BaseClass {
	 @Test(dataProvider = "RegisterDataProvider")
	
	   public void fillRegistrationForm(String firstName, 
			   String lastName, String email, String password, String confirmPassword) {
		driver.get(urls);
//		ExtendReports intializeExtenReport1 = new ExtendReports();
//		intializeExtenReport1.intializeExtenReport();
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnRegister();
		
		RegisterPage registerPage= new RegisterPage(driver);
        registerPage.selectGender("male");
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
//        registerPage.selectDateOfBirth(day,month, year);
        registerPage.enterEmail(email);
        registerPage.enterEmail(password, confirmPassword);
        registerPage.clickRegister();
		
		
		
	}
	   @DataProvider(name = "RegisterDataProvider")
	    public Object[][] provideLoginData() throws IOException {
	        String fileName = System.getProperty("user.dir") + "\\TestData\\nopcommerce.xlsx";

	        int totalRows = ExcelUtilities.getRowCount(fileName, "RegisterDate");
	        int totalColumns = ExcelUtilities.getColCount(fileName, "RegisterDate");

	        Object[][] data = new Object[totalRows - 1][totalColumns];

	        for (int i = 1; i < totalRows; i++) {
	            for (int j = 0; j < totalColumns; j++) {
	                data[i - 1][j] = ExcelUtilities.getCellValue(fileName, "RegisterDate", i, j);
	            }
	        }
	        return data;
	    }

}
