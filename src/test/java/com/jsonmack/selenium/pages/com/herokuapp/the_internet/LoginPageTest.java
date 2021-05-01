package com.jsonmack.selenium.pages.com.herokuapp.the_internet;

import com.jsonmack.selenium.WebDriverFactory;
import com.jsonmack.selenium.pages.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jason MacKeigan
 */
class LoginPageTest {

    private static final String URL = "https://the-internet.herokuapp.com/login";

    private static final String LOGGED_IN = "https://the-internet.herokuapp.com/secure";

    @Test
    public void successful() {
        WebDriver driver = WebDriverFactory.local();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.visit(URL);

        LoginPageWithErrors withErrors = loginPage.withErrors(driver, "tomsmith", "SuperSecretPassword!");

        WebDriverWait wait = new WebDriverWait(driver, 3);

        wait.pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.urlToBe(LOGGED_IN));

        Assertions.assertTrue(withErrors.isErrorDisplayed());

        driver.quit();
    }

}
