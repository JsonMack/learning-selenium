package com.jsonmack.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Jason MacKeigan
 */
public class LinkedInLearningScrollTest {

    @Test
    public void scrollTest() {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/scroll");

        WebElement name = driver.findElement(By.id("name"));

        Actions actions = new Actions(driver);

        actions.moveToElement(name);

        driver.quit();
    }
}
