package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderFoodOrderPage;
import com.test.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderFoodOrderStepDef {
    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);
    WebOrderFoodOrderPage webOrderFoodOrderPage = new WebOrderFoodOrderPage(driver);

    @Given("User provides username and password for successful login")
    public void user_provides_username_and_password_for_successful_login() throws InterruptedException {
        webOrderLoginPage.login(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));
    }
    @When("User clicks order box and next button")
    public void user_clicks_order_box_and_next_button() {
        webOrderFoodOrderPage.clickGroupOrderBox();
        webOrderFoodOrderPage.clickNextButton();
    }
    @When("User provides note {string} to invitees box")
    public void user_provides_note_to_invitees_box(String message) throws InterruptedException {
        webOrderFoodOrderPage.sendInviteesMessage(message);
    }
    @When("User provides gmail {string},{string} to InviteList")
    public void emails_to_invite_list(String email1, String email2) throws InterruptedException {
        webOrderFoodOrderPage.sendInviteList(email1, email2);
    }
    @When("User chooses the location {string} and validates the address {string}")
    public void user_chooses_the_location_and_validates_address_contains(String expectedLocation, String expectedAddress) throws InterruptedException {
        webOrderFoodOrderPage.chooseLocation(expectedLocation, expectedAddress);
    }
    @When("User clicks Create Group Order Button")
    public void user_clicks_group_order_button() throws InterruptedException {
        webOrderFoodOrderPage.clickCreateGroupOrderButton();
    }
    @Then("User validates the header {string} and {string} from description")
    public void user_validates_the_and_from_description(String expectedHeader, String expectedDescription) throws InterruptedException {
        webOrderFoodOrderPage.validateHeaderAndDescription(expectedHeader, expectedDescription);
    }
}
