package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final By TITLE = By.cssSelector(".title");
    private final By PRODUCT_NAME = By.xpath("//a[@id='item_4_title_link']/div");
    private final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final By CHECK_OUT_BUTTON = By.id("checkout");
    private final By CART = By.cssSelector(".shopping_cart_link");
    private final By BURGER_BUTTON = By.id("react-burger-menu-btn");
    private final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    private final String removeButton = "//div[text()='%s']/ancestor::div[@class='cart_item']//button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }

    public WebElement getProductName() {
        return driver.findElement(PRODUCT_NAME);

    }

    public void removeProductFromCart(String productName) {
        By fullLocator = By.xpath(String.format(removeButton, productName));
        driver.findElement(fullLocator).click();
    }

    public int getProducts() {
        return driver.findElements(PRODUCT_NAME).size();
    }

    public void openCart() {
        driver.findElement(CART).click();
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void checkout() {
        driver.findElement(CHECK_OUT_BUTTON).click();
    }
    public void openBurgerMenu() {
        driver.findElement(BURGER_BUTTON).click();
    }
    public void logout() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
}