package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue= {"StepDefinitions"},
monochrome = true,
plugin = {"pretty","json:target/JSONReports/report.json"}
		)
public class TestRunner {

}
