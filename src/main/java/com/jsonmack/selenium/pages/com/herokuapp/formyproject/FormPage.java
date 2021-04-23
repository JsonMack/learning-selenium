package com.jsonmack.selenium.pages.com.herokuapp.formyproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

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
    private WebElement sex;

    @FindBy(how = How.ID, id = "select-menu")
    private WebElement yearsOfExperience;

    @FindBy(how = How.ID, id = "datepicker")
    private WebElement date;

    public FormPage(WebElement firstName, WebElement lastName, WebElement jobTitle, List<WebElement> highestLevelOfEducation,
                    WebElement sex, WebElement yearsOfExperience, WebElement date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.highestLevelOfEducation = highestLevelOfEducation;
        this.sex = sex;
        this.yearsOfExperience = yearsOfExperience;
        this.date = date;
    }

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getJobTitle() {
        return jobTitle;
    }

    public List<WebElement> getHighestLevelOfEducation() {
        return highestLevelOfEducation;
    }

    public WebElement getSex() {
        return sex;
    }

    public WebElement getYearsOfExperience() {
        return yearsOfExperience;
    }

    public WebElement getDate() {
        return date;
    }
}
