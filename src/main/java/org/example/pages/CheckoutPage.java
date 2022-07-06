package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By POSTAL_CODE = By.id("postal-code");
    private final By CANCEL_BUTTON = By.id("cancel");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By SHOPPING_CART = By.cssSelector(".shopping_cart_link");
    private final By BURGER_MENU_BUTTON = By.id("react-burger-menu-btn");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }

    public void enterYourInformation() {
        driver.findElement(FIRST_NAME).sendKeys("Ivan");
        driver.findElement(LAST_NAME).sendKeys("Ivanov");
        driver.findElement(POSTAL_CODE).sendKeys("999999");
    }

    public void cancelCheckout() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void continuePurchase() {
        driver.findElement(CONTINUE_BUTTON).click();
    }


    public By getFIRST_NAME() {
        return FIRST_NAME;
    }

    public By getLAST_NAME() {
        return LAST_NAME;
    }

    public By getPOSTAL_CODE() {
        return POSTAL_CODE;
    }
}