package com.jsonmack.selenium.pages.com.herokuapp.the_internet;

import com.jsonmack.selenium.pages.SeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Jason MacKeigan
 */
public class LoginPage extends SeleniumPage {

    private static final String URL = "https://the-internet.herokuapp.com/login";

    @FindBy(how = How.ID, id = "username")
    private WebElement username;

    @FindBy(how = How.ID, id = "password")
    private WebElement password;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"login\"]")
    private WebElement button;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPageWithErrors withErrors(WebDriver driver, String username, String password) {
        type(username, this.username);
        type(password, this.password);
        click(button);

        return new LoginPageWithErrors(driver);
    }

}
