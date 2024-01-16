package com.nopcommerce.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver rdriver) {
        driver = rdriver;
    }

    By genderMaleRadio = By.id("gender-male");
    By genderFemaleRadio = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By dateOfBirthDay = By.name("DateOfBirthDay");
    By dateOfBirthMonth = By.name("DateOfBirthMonth");
    By dateOfBirthYear = By.name("DateOfBirthYear");
    By password= By.id("Password");
	By confirmPassword= By.id("ConfirmPassword");
    By registerButton = By.id("register-button");

    public void selectGender(String gender) {
        WebElement genderRadio;
        if (gender.equalsIgnoreCase("male")) {
            genderRadio = driver.findElement(genderMaleRadio);
        } else if (gender.equalsIgnoreCase("female")) {
            genderRadio = driver.findElement(genderFemaleRadio);
        } else {
            throw new IllegalArgumentException("Invalid gender provided");
        }
        genderRadio.click();
    }

    public void enterFirstName(String firstNames) {
        driver.findElement(firstName).sendKeys(firstNames);
    }

    public void enterLastName(String lastNames) {
        driver.findElement(lastName).sendKeys(lastNames);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        Select dayDropdown = new Select(driver.findElement(dateOfBirthDay));
        Select monthDropdown = new Select(driver.findElement(dateOfBirthMonth));
        Select yearDropdown = new Select(driver.findElement(dateOfBirthYear));

        dayDropdown.selectByVisibleText(day);
        monthDropdown.selectByVisibleText(month);
        yearDropdown.selectByVisibleText(year);
    }

    public void enterEmail(String emailAddress) {
        driver.findElement(email).sendKeys(emailAddress);
    }
    public void enterEmail(String passwordRegister, String confirmpassword) {
        driver.findElement(password).sendKeys(passwordRegister);
        driver.findElement(confirmPassword).sendKeys(confirmpassword);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }
}
