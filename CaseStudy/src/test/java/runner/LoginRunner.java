package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src//main//resources//features",
		glue= {"stepdefs"},
		strict = true,
		monochrome = true,
		tags = {"@E2ETest"}, 
		plugin= {"pretty","com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}	
		)
public class LoginRunner {

}
