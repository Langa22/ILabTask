package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/featurefiles/steps.feature",
                glue = "stepDefinitions",
                plugin = {"summary","pretty","html:target/cucumber-reports.html"},
                monochrome = true)

public class TestRunner {
}
