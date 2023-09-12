package com.test.google.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="target/uiFailedTests.txt", //feature files Locai
        glue="com/test/weborder/stepdefinitions",
        tags ="@regression",
        plugin = {"pretty","html:target"}



)
public class WebOrderRunner {

}
