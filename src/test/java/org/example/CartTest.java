package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {


    @Test
    public void productIsAddedToCart() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCart();
        Assert.assertEquals(cartPage.getProductName().getText(), "Sauce Labs Backpack", "Product is not added to cart");
    }

    @Test
    public void removeProductFromCart() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.removeProductFromCart("Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getProducts(), 0, "Product is not deleted from cart");
    }

    @Test
    public void continueShopping() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        cartPage.openCart();
        cartPage.continueShopping();
        Assert.assertTrue(productsPage.getTitle().isDisplayed(), "The continue shopping button does not redirect to the product page");
    }

    @Test
    public void openToCheckout() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        cartPage.openCart();
        cartPage.checkout();
        Assert.assertEquals(cartPage.getTitle().getText(), "CHECKOUT: YOUR INFORMATION", "The checkout button does not redirect to the checkout page");
    }
    @Test
    public void openBurgerMenuAndLogout() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        cartPage.openCart();
        cartPage.openBurgerMenu();
        cartPage.logout();
        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed(), "The logout button does not redirect to the login page");
    }
}