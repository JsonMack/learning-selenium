package com.jsonmack.selenium.pages.com.herokuapp.formyproject;

import com.jsonmack.selenium.WebDriverFactory;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

/**
 * @author Jason MacKeigan
 */
public class FormPageTest {

    private static final String FORM_URL = "https://formy-project.herokuapp.com/form";

    @Test
    @Disabled
    public void assertWaitForThanks() {
        WebDriver driver = WebDriverFactory.local();

        driver.get(FORM_URL);

        FormPage formPage = form(driver);

        formPage.submit();

        waitForThanks(driver);
    }

    @Test
    public void assertRemoteWaitForThanks() throws IOException {
        WebDriver driver =  WebDriverFactory.remoteFromFile();

        driver.get(FORM_URL);

        waitForThanks(driver);
    }

    private FormPage form(WebDriver driver) {
        FormPage formPage = new FormPage(driver);

        formPage.fill("Jason", "MacKeigan", "Null", "radio-button-1", "checkbox-1", "1", "04/23/2021");

        return formPage;
    }

    private void waitForThanks(WebDriver driver) {
        FluentWait<WebDriver> wait = new WebDriverWait(driver, 3);

        wait.pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.urlContains("/thanks"));
    }

}
