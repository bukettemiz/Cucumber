package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBeartMainPage {
    public SmartBeartMainPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Order")
    WebElement OrderClick;
    @FindBy(partialLinkText = "all orders")
    WebElement viewAllOrdersButton;
    public void orderClickFunc(){
        OrderClick.click();
    }
    public void clickViewAllOrdersButton(){
        viewAllOrdersButton.click();
    }
}
