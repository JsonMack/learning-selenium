package com.jsonmack.selenium.pages.com.saucedemo;

import com.jsonmack.selenium.WebDriverFactory;
import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

/**
 * @author Jason MacKeigan
 */
@DisplayName("LoginPage Test")
class LoginPageTest {

    private static final String URL = "https://www.saucedemo.com/";

    private static final String SUCCESSFUL_URL = "https://www.saucedemo.com/inventory.html";

    private static WebDriver driver;

    private LoginPage loginPage;

    @BeforeAll
    public static void beforeAll() throws IOException {
        driver = WebDriverFactory.remoteFromFile();

        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @BeforeEach
    void beforeEach() {
        loginPage = new LoginPage(driver);
    }

    @ParameterizedTest
    @CsvSource({"standard_user,secret_sauce"})
    @Order(1)
    void fillSuccessfulUser(String username, String password) {
        loginPage.fill(username, password);

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.and(
                        ExpectedConditions.textToBePresentInElement(loginPage.getUsername(), username),
                        ExpectedConditions.textToBePresentInElement(loginPage.getPassword(), password)));
    }

    @Test
    @Order(2)
    void submit() {
        loginPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.urlToBe(SUCCESSFUL_URL));
    }
}
