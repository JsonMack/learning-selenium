package com.jsonmack.selenium;

import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Jason MacKeigan
 */
public class WebDriverFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");

    }

    public static WebDriver local() {
        return new ChromeDriver(new ChromeDriverService.Builder()
                .withSilent(true)
                .usingAnyFreePort()
                .build(),
                new ChromeOptions().addArguments("--incognito"));
    }

    public static WebDriver localNode(String address) throws MalformedURLException {
        return new RemoteWebDriver(new URL(address),
                ImmutableCapabilities.copyOf(DesiredCapabilities.chrome()));
    }

}
