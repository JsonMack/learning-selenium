package com.jsonmack.selenium.pages.com.herokuapp.formyproject;

import com.jsonmack.selenium.StandardWebDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Jason MacKeigan
 */
public class FormPageTest {

    @Test
    public void fill() {
        WebDriver driver = new StandardWebDriver().getDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage(driver);

        formPage.fill("Jason", "MacKeigan", "Null", "radio-button-1", "checkbox-1", "1", "04/23/2021");

        formPage.submit();

        FluentWait<WebDriver> wait = new WebDriverWait(driver, 3);

        wait.pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.urlContains("/thanks"));

    }

}
