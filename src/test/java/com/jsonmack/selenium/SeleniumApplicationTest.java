package com.jsonmack.selenium;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.gen5.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * A
 *
 * @author Jason
 */
@RunWith(JUnit4.class)
public class SeleniumApplicationTest {

/**
 * Gherkin
 *      Uses *keywords* for structure
 *          Can use various languages
 *          Keywords are
 *              Feature
 *                  The primary or root keyword used in a Gherkin document and must be followed by :
 *
 *              Rule
 *                  Introduced in version 6
 *                  Contains 1 or more Scenarios
 *              Example (Scenario)
 *                  Scenario is a synonym for example.
 *                  Should consist of the following in order
 *                      Given -> When -> Then
 *              Steps
 *                  Given
 *                  When
 *                  Then
 *                  And
 *                  But
 *                  * for All (assumed)
 *              Background
 *              Scenario Outline (Scenario Template)
 *              Examples (Scenarios)
 *                  Recommended 3-5 steps per example to keep it short and sweet.
 *          Secondary Keywords
 *              """ -   Doctypes
 *              | -     Data tables
 *              @ -     Tags
 *              # -     Comments
 *              : -     Denotes split or delimiter for keyword
 *          Comments can be used starting with #
 *              Block comments are not supported
 *      The segment of code following a *keyword* is a step definition
 *
 */

    private static final String REGISTER_URL = "http://127.0.0.1:8000/pages/student/register";

    private final SeleniumItJobFairApplication application = new SeleniumItJobFairApplication();

    private final WebDriver driver = application.getDriver();

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
    }

    @BeforeAll
    public void beforeAll() {
        application.getDriver().get(REGISTER_URL);
    }

    @Test
    public void studentId() throws InterruptedException {
        String registerUrl = "http://127.0.0.1:8000/pages/student/register";

        driver.get(registerUrl);

        driver.findElement(By.name("w_number"))
                .sendKeys("w0270100");

        driver.findElement(By.name("first_name"))
                .sendKeys("Test");

        driver.findElement(By.name("last_name"))
                .sendKeys("Test");

        Select programId = new Select(driver.findElement(By.name("program_id")));

        programId.selectByValue("1");

        Select campus = new Select(driver.findElement(By.name("campus")));

        campus.selectByValue("Institute of Technology Campus");

        Select gradYear = new Select(driver.findElement(By.name("grad_year")));

        gradYear.selectByValue("2022");

        driver.findElement(By.id("mentor_requested_yes")).click();

        driver.findElement(By.id("special_projects_yes")).click();

        driver.findElement(By.id("share_information_yes")).click();

        driver.findElement(By.id("include_portfolio_links_yes")).click();

        Queue<String> links = new ArrayDeque<>(Arrays.asList(
                "https://google.com/", "https://bing.com", "https://askjeeves.com"));

        driver.findElements(By.name("portfolio_link[]")).get(0).sendKeys(links.poll());

        driver.findElement(By.id("add_portfolio_link")).click();

        driver.findElements(By.name("portfolio_link[]")).get(1).sendKeys(links.poll());

        driver.findElement(By.id("add_portfolio_link")).click();

        driver.findElements(By.name("portfolio_link[]")).get(2).sendKeys(links.poll());

        WebElement form = driver.findElement(By.name("studentForm"));

        form.submit();


        while (driver.getCurrentUrl().equals(registerUrl)) {
            Thread.sleep(1_000);

            System.out.println("Current url is still register, waiting for redirect...");
        }

        System.out.println("Current url after redirect: " + driver.getTitle());

        driver.quit();
    }
}
