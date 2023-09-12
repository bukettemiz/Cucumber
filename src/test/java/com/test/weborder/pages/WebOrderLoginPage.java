package com.test.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderLoginPage {
    public WebOrderLoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='Email']")
    WebElement username;

    @FindBy(css = "#Password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(css = ".alert-danger")
    WebElement errorMessage;
    public void login(String username,String password) throws InterruptedException {
        this.username.clear();
        Thread.sleep(2000);
        this.username.sendKeys(username);
        this.password.clear();
        Thread.sleep(2000);
        this.password.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();
        Thread.sleep(2000);

    }
    public String ErrorMessageValidation(){

        return BrowserUtils.getText(errorMessage);
    }

}
