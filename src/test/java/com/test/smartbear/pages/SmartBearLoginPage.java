package com.test.smartbear.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage {
    public SmartBearLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#ctl00_MainContent_username")
    WebElement userNameInput;
    @FindBy(css = "#ctl00_MainContent_password")
    WebElement passwordInput;
    @FindBy(css = ".button")
    WebElement loginButton;
    public void login(String name,String password){

        userNameInput.sendKeys(name);
        passwordInput.sendKeys(password);
        loginButton.click();

    }
}
