package mt.com.ecabs.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "classpath:features/UITests_Task2.feature" },
        glue = {"mt.com.ecabs.automation.stepdefinitions.StepDefinitions" })
public class UITestRunner {
}
