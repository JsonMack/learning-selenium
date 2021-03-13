package com.jsonmack.selenium;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author Jason
 */
@RunWith(JUnit4.class)
public class SeleniumApplicationTest {

    private static SeleniumItJobFairApplication application;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");

        application = new SeleniumItJobFairApplication();
    }

    @Test
    public void studentId() throws InterruptedException {
        WebDriver driver = application.getDriver();

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
            Thread.sleep(2_000);

            System.out.println("Current url is still register, waiting for redirect...");
        }

        System.out.println("Current url after redirect: " + driver.getTitle());
    }
}
