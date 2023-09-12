package com.test.smartbear.smartbearStepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class SmartBearHook {
    WebDriver driver= DriverHelper.getDriver();

    @Before
    public void setup(){
        driver.get(ConfigReader.readProperty("QA_SmartBearUrl"));
    }
    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotForCucumber(driver,scenario);
        //driver.quit();
    }
}
