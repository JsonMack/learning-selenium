package com.jsonmack.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Jason MacKeigan
 */
public class SeleniumItJobFairApplication {

    private final WebDriver driver;

    public SeleniumItJobFairApplication(WebDriver driver) {
        this.driver = driver;
    }

    public SeleniumItJobFairApplication() {
        this(new ChromeDriver(new ChromeDriverService.Builder()
                .withSilent(true)
                .usingAnyFreePort()
                .build(),
                new ChromeOptions().addArguments("--incognito")));
    }

    public WebDriver getDriver() {
        return driver;
    }
}
