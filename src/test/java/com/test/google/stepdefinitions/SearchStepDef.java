package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);
    @Given("User navigates to the google")
    public void user_navigates_to_the_google() {
        driver.get("https://www.google.com/");
    }

    @When("User searches for CodeFish")
    public void user_searches_for_code_fish() {
        googleMainPage.searchItem("CodeFish");

    }

    @Then("User validates first page returns more than ten links")
    public void user_validates_first_page_returns_more_than_ten_links() {
        Assert.assertTrue(googleMainPage.linkCount(10));
    }
    @When("User searches for Kyrgyz Food in USA")
    public void user_searches_for_kyrgyz_food_in_usa() {
       googleMainPage.searchItem("Kyrgyz Food in USA");
    }
    @Then("User validates the result is three hundred million")
    public void user_validates_the_result_is_three_hundred_million() {
        Assert.assertTrue(googleMainPage.resultFromSearch(300000000));
    }
    @When("User searches for Turkish Baklava")
    public void user_searches_for_turkish_baklava() {
        googleMainPage.searchItem("Turkish Baklava");
    }
    @Then("User validates the loading time is less than one sec")
    public void user_validates_the_loading_time_is_less_than_one_sec() {
       Assert.assertTrue(googleMainPage.timingFromResearch(1.0));
    }

}