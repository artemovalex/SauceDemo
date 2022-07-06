package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkFinishCheckout() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.checkout();
        checkoutPage.enterYourInformation();
        checkoutPage.continuePurchase();
        Assert.assertTrue(driver.findElement(By.id("finish")).isDisplayed(), "You entered invalid your information");
    }

    @Test
    public void firstNameIsRequiredForCheckout() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.checkout();

        driver.findElement(checkoutPage.getLAST_NAME()).sendKeys("Ivanov");
        driver.findElement(checkoutPage.getPOSTAL_CODE()).sendKeys("999999");
        checkoutPage.continuePurchase();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText(),
                "Error: First Name is required", "Validation of first name is failed");
    }

    @Test
    public void lastNameIsRequiredForCheckout() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.checkout();

        driver.findElement(checkoutPage.getFIRST_NAME()).sendKeys("Ivan");
        driver.findElement(checkoutPage.getPOSTAL_CODE()).sendKeys("999999");
        checkoutPage.continuePurchase();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText(),
                "Error: Last Name is required", "Validation of last name is failed");
    }

    @Test
    public void postCodeIsRequiredForCheckout() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.checkout();

        driver.findElement(checkoutPage.getFIRST_NAME()).sendKeys("Ivan");
        driver.findElement(checkoutPage.getLAST_NAME()).sendKeys("Ivanov");
        checkoutPage.continuePurchase();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText(),
                "Error: Postal Code is required", "Validation of postal code is failed");
    }

    @Test
    public void checkCancelCheckout() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.checkout();
        checkoutPage.cancelCheckout();
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "YOUR CART", "Redirect to cart page is failed");
    }
}