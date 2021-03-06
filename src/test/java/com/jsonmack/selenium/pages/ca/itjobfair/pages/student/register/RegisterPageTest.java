package com.jsonmack.selenium.pages.ca.itjobfair.pages.student.register;

import com.jsonmack.selenium.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

/**
 * A
 *
 * @author Jason
 */
public class RegisterPageTest {

    private static final String REGISTER_URL = "http://127.0.0.1:8000/pages/student/register";

    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");

        driver = WebDriverFactory.local();

        driver.get(REGISTER_URL);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void successful() {
        RegisterPage page = new RegisterPage(driver);

        page.fill("w0270165", "Jason", "MacKeigan",
                "Institute of Technology Campus", "2022", "IT Programming", true, true, true, true,
                Arrays.asList("https://google.com/", "https://bing.com", "https://askjeeves.com"));

        page.submit();

        FluentWait<WebDriver> wait = new WebDriverWait(driver, 10)
                .pollingEvery(Duration.ofSeconds(1));

        wait.until(ExpectedConditions.titleIs("Student Email Verification"));
    }
}
