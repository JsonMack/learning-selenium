package com.jsonmack.selenium;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Jason MacKeigan
 */
public class LinkedInLearningAutocompleteTest {

    @Test
    public void autocompleteTest() {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement address = driver.findElement(By.id("autocomplete"));

        address.sendKeys("1234");

        

        driver.quit();
    }
}
