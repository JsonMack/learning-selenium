package com.jsonmack.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Jason MacKeigan
 *
 * Represents a page from the Page Object Model pattern that can be used to separate test functionality
 * and page functionality for better test development.
 */
public interface Page {

    WebElement find(By locator);

    void visit(String url);

    void click(WebElement element);

    void type(String text, WebElement element);

    boolean displayed(WebElement element);

}
