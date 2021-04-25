package com.jsonmack.selenium.pages.com.herokuapp.formyproject;

import com.jsonmack.selenium.WebDriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

/**
 * @author Jason MacKeigan
 */
public class DatePickerPageTest {

    @Test
    public void assertValidInput() {
        WebDriver driver = WebDriverFactory.local();

        driver.get("https://formy-project.herokuapp.com/datepicker");

        DatePickerPage page = new DatePickerPage(driver);

        LocalDate date = LocalDate.of(1970, 1, 1);

        page.fill(date);

        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.textToBePresentInElementValue(page.getDatepicker(), "01/01/1970"));

        driver.close();
    }

}
