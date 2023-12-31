package com.test.weborder.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTests.txt",
        glue="com/test/weborder/stepdefinitions",
        tags = "@ragression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTest"}
)
public class WebOrderReRunner {
}
