package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WebOrderLoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage=new WebOrderLoginPage(driver);

    @When("User provides {string},{string} and click Login button")
    public void user_provides_and_click_login_button(String username, String password) throws InterruptedException {
         webOrderLoginPage.login(username,password);
    }


    @Then("User validates the error {string}")
    public void user_validates_the_error(String expectedMessage) {
        expectedMessage = "Sign in Failed";
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(expectedMessage,webOrderLoginPage.ErrorMessageValidation());
    }

    @Then("User validates the {string}")
    public void user_validates_the(String expectedTitle){
        System.out.println(expectedTitle + " this is expected title");
        System.out.println(driver.getTitle().trim());
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }

    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) {
        System.out.println(expectedMessage + " this is expected value ");
        System.out.println(webOrderLoginPage.ErrorMessageValidation() + " error message");
        Assert.assertEquals(expectedMessage,webOrderLoginPage.ErrorMessageValidation());

    }
}

