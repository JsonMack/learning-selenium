package com.jsonmack.selenium.pages.com.herokuapp.formy_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * @author Jason MacKeigan
 */
public class FormPage {

    @FindBy(how = How.ID, id = "first-name")
    private WebElement firstName;

    @FindBy(how = How.ID, id = "last-name")
    private WebElement lastName;

    @FindBy(how = How.ID, id = "job-title")
    private WebElement jobTitle;

    @FindAll({
            @FindBy(how = How.ID, id = "radio-button-1"),
            @FindBy(how = How.ID, id = "radio-button-2"),
            @FindBy(how = How.ID, id = "radio-button-3")
    })
    private List<WebElement> highestLevelOfEducation;

    @FindAll({
            @FindBy(how = How.ID, id = "checkbox-1"),
            @FindBy(how = How.ID, id = "checkbox-2"),
            @FindBy(how = How.ID, id = "checkbox-3")
    })
    private List<WebElement> sex;

    @FindBy(how = How.ID, id = "select-menu")
    private WebElement yearsOfExperience;

    @FindBy(how = How.ID, id = "datepicker")
    private WebElement date;

    @FindBy(how = How.CLASS_NAME, className = "btn")
    private WebElement submit;

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fill(String firstName, String lastName, String jobTitle, String highestLevelOfEducation, String sex, String yearsOfExperience, String date) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.jobTitle.sendKeys(jobTitle);

        this.highestLevelOfEducation.stream()
                .filter(webElement -> webElement.getAttribute("id").equals(highestLevelOfEducation))
                .findAny()
                .orElseThrow()
                .click();

        this.sex.stream()
                .filter(webElement -> webElement.getAttribute("id").equals(sex))
                .findAny()
                .orElseThrow()
                .click();

        Select select = new Select(this.yearsOfExperience);

        select.selectByValue(yearsOfExperience);

        this.date.sendKeys(date);
    }

    public void submit() {
        submit.click();
    }
}
