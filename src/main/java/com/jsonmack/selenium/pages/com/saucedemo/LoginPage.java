package com.jsonmack.selenium.pages.com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Jason MacKeigan
 */
public class LoginPage {

    @FindBy(how = How.ID, id = "user-name")
    private WebElement username;

    @FindBy(how = How.ID, id = "password")
    private WebElement password;

    @FindBy(how = How.ID, css = "login-button")
    private WebElement login;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fill(String username, String password) {
        this.username.click();
        this.username.sendKeys(username);
        this.password.click();
        this.password.sendKeys(password);
    }

    public void submit() {
        this.login.click();
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogin() {
        return login;
    }
}
