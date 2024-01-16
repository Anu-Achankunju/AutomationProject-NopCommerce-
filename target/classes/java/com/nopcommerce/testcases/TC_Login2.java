package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.page.HomePage;
import com.nopcommerce.page.LoginPage;
import com.nopcommerce.utilities.ExcelUtilities;
import com.nopcommerce.utilities.ExtendReports;

public class TC_Login2 extends BaseClass {

    @Test(dataProvider = "LoginDataProvider")
    public void LoginTC(String username, String password) throws IOException {
        driver.get(urls); 
System.out.println(urls);
        HomePage homepage = new HomePage(driver);
        homepage.clickOnLogin();
        
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterLoginDetails(username, password);
        loginpage.clickLogin();
        
        if (driver.getCurrentUrl().equals("https://demo.nopcommerce.com/")) {
//        	System.out.println("+++++++++)))))))))(((((((("+driver.getCurrentUrl());
            Assert.assertTrue(true);
        } else {
            captureScreenShot(driver, "LoginTC");
            System.out.println("+++++++++)))))))))(((((((("+driver.getCurrentUrl());
            System.out.println("Test case has failed ++++++++++++++++++++++++++++");
            Assert.assertTrue(false);
        }
    }

    @DataProvider(name = "LoginDataProvider")
    public Object[][] provideLoginData() throws IOException {
        String fileName = System.getProperty("user.dir") + "\\TestData\\nopcommerce.xlsx";

        int totalRows = ExcelUtilities.getRowCount(fileName, "LoginDate");
        int totalColumns = ExcelUtilities.getColCount(fileName, "LoginDate");

        Object[][] data = new Object[totalRows - 1][totalColumns];

        for (int i = 1; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                data[i - 1][j] = ExcelUtilities.getCellValue(fileName, "LoginDate", i, j);
            }
        }
        return data;
    }
}
