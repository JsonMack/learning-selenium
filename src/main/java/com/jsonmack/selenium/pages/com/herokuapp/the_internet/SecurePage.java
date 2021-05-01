package com.jsonmack.selenium.pages.com.herokuapp.the_internet;

import com.jsonmack.selenium.pages.SeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Jason MacKeigan
 */
public class SecurePage extends SeleniumPage {

    @FindBy(how = How.CLASS_NAME, className = "button")
    private WebElement logout;

    @FindBy(how = How.ID, id = "flash")
    private WebElement flashMessage;

    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isFlashMessageDisplayed() {
        return flashMessage.isDisplayed();
    }

    public boolean isLogoutDisplayed() {
        return logout.isDisplayed();
    }
}
