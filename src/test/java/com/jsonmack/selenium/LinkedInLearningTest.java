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
public class LinkedInLearningTest {

    @Test
    public void mouseAndKeyboardInput() {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/keypress");

        WebElement name = driver.findElement(By.id("name"));

        name.click(); // get focus for field

        name.sendKeys("Jason");

        WebElement button = driver.findElement(By.id("button"));

        button.click();

        driver.quit();
    }

}
