package com.jsonmack.selenium.pages.com.herokuapp.the_internet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Jason MacKeigan
 */
public class LoginPageWithErrors extends LoginPage {

    @FindBy(how = How.CSS, css = "flash")
    private WebElement message;

    public LoginPageWithErrors(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isErrorDisplayed() {
        return message.isDisplayed();
    }

}
