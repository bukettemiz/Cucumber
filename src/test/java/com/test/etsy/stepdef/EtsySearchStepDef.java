package com.test.etsy.stepdef;

import com.test.etsy.pages.EtsyMainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class EtsySearchStepDef {
      WebDriver driver= DriverHelper.getDriver();
      EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
    @When("User searches for {string} for Etsy")
    public void user_searches_for_for_etsy(String item) {

        etsyMainPage.searchItem(item);
    }
    @Then("User validates the title {string} from Etsy")
    public void user_validates_the_title_from_etsy(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
}
