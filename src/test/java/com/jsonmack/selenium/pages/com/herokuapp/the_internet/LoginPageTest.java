package com.jsonmack.selenium.pages.com.herokuapp.the_internet;

import com.jsonmack.selenium.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Jason MacKeigan
 */
class LoginPageTest {

    private static final String URL = "https://the-internet.herokuapp.com/login";

    private static final String LOGGED_IN = "https://the-internet.herokuapp.com/secure";

    private static final String CORRECT_PASSWORD = "SuperSecretPassword!";

    private static final String CORRECT_USERNAME = "tomsmith";

    private static final String INCORRECT_PASSWORD = "foo";

    private static final WebDriver driver = WebDriverFactory.local();

    @AfterAll
    static void afterAll() {
        driver.quit();
    }

    @Test
    public void successful() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.visit(URL);

        loginPage.credentials(CORRECT_USERNAME, CORRECT_PASSWORD);

        new WebDriverWait(driver, 3)
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.urlToBe(LOGGED_IN));

        SecurePage securePage = new SecurePage(driver);

        Assertions.assertTrue(securePage.isFlashMessageDisplayed());
    }

    @Test
    public void failed() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.visit(URL);
        loginPage.credentials(CORRECT_USERNAME, INCORRECT_PASSWORD);

        Assertions.assertTrue(loginPage.isErrorMessageDisplayed());
    }

}
