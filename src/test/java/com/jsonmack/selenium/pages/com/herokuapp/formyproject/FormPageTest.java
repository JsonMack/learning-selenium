package com.jsonmack.selenium.pages.com.herokuapp.formyproject;

import com.jsonmack.selenium.StandardWebDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

/**
 * @author Jason MacKeigan
 */
public class FormPageTest {

    @Test
    public void fill() {
        WebDriver standardWebDriver = new StandardWebDriver().getDriver();

        standardWebDriver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage(standardWebDriver);

        System.out.println(formPage.getSex());
    }

}
