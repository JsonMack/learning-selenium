package com.jsonmack.selenium.pages.com.herokuapp.formyproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Jason MacKeigan
 */
public class DatePickerPage {

    @FindBy(how = How.ID, id = "datepicker")
    private WebElement datepicker;

    public DatePickerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fill(LocalDate date) {
        datepicker.sendKeys(date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
    }

    public WebElement getDatepicker() {
        return datepicker;
    }

}
