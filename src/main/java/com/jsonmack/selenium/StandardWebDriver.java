package com.jsonmack.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Jason MacKeigan
 */
public class StandardWebDriver implements Closeable, AutoCloseable {

    private final WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");

    }

    public StandardWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public StandardWebDriver() {
        this(new ChromeDriver(new ChromeDriverService.Builder()
                .withSilent(true)
                .usingAnyFreePort()
                .build(),
                new ChromeOptions().addArguments("--incognito")));
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void close() throws IOException {
        driver.quit();
    }
}
