package com.jsonmack.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Jason MacKeigan
 */
public class SeleniumPage implements Page {

    private final WebDriver driver;

    public SeleniumPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    @Override
    public void visit(String url) {
        driver.get(url);
    }

    @Override
    public void click(WebElement element) {
        element.submit();
    }

    @Override
    public void type(String text, WebElement element) {
        element.sendKeys(text);
    }

    @Override
    public boolean displayed(WebElement element) {
        return element.isDisplayed();
    }
}
