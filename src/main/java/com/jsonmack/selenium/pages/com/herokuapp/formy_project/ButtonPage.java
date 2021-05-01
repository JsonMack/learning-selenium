package com.jsonmack.selenium.pages.com.herokuapp.formy_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Jason MacKeigan
 */
public class ButtonPage {

    @FindBy(how = How.XPATH, xpath = "/html/body/div/form/div[1]/div/div/button[1]")
    private WebElement primary;

    @FindBy(how = How.XPATH, xpath = "/html/body/div/form/div[1]/div/div/button[2]")
    private WebElement success;

    @FindBy(how = How.XPATH, xpath = "/html/body/div/form/div[1]/div/div/button[3]")
    private WebElement info;

    @FindBy(how = How.XPATH, xpath = "/html/body/div/form/div[1]/div/div/button[4]")
    private WebElement warning;

    @FindBy(how = How.XPATH, xpath = "/html/body/div/form/div[1]/div/div/button[5]")
    private WebElement danger;

    @FindBy(how = How.XPATH, xpath = "/html/body/div/form/div[2]/div/div/div/button[1]")
    private WebElement left;

    @FindBy(how = How.XPATH, xpath = "/html/body/div/form/div[2]/div/div/div/button[2]")
    private WebElement middle;

    @FindBy(how = How.XPATH, xpath = "/html/body/div/form/div[2]/div/div/div/button[3]")
    private WebElement right;

    public ButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getPrimary() {
        return primary;
    }
}
