package com.ecabs.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "classpath:features/search.feature" },
        glue = {"com.askgamblers.cm.automation.runner.LoginSteps" })
public class TestRunner {
}
