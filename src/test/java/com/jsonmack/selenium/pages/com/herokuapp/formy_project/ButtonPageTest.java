package com.jsonmack.selenium.pages.com.herokuapp.formy_project;

import com.jsonmack.selenium.WebDriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

/**
 * @author Jason MacKeigan
 */
class ButtonPageTest {

    @Test
    void assertClickable() throws MalformedURLException {
        WebDriver driver = WebDriverFactory.localNode("http://192.168.2.15:4444/wd/hub");

        driver.get("https://formy-project.herokuapp.com/buttons");

        ButtonPage page = new ButtonPage(driver);

        FluentWait<WebDriver> wait = new WebDriverWait(driver, 2);

        wait.pollingEvery(Duration.ofMillis(250))
                .until(ExpectedConditions.elementToBeClickable(page.getPrimary()));

        driver.quit();
    }


}
