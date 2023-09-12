package com.test.weborder.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/weborder", //location of faturefile
        glue = "com/test/weborder/stepdefinitions", //stepdefinitions files location
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTest"}
)
public class WebOrderRunner {
}
