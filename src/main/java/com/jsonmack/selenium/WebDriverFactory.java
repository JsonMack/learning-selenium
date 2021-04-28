package com.jsonmack.selenium;

import com.jsonmack.selenium.settings.Settings;
import com.jsonmack.selenium.settings.SettingsFactory;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

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

    public static WebDriver remote(Settings settings) throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.MAC);
        capabilities.setVersion("90.0.4430.93");

        return new RemoteWebDriver(new URL(settings.getSauceLabsUrl()), capabilities);
    }

    public static WebDriver remoteFromFile() throws IOException {
        Settings settings = SettingsFactory.fromJson(Paths.get("src", "test", "resources", "application.json"));

        return remote(settings);
    }

}
