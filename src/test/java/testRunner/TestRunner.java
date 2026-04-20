package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/java/features",glue = "stepDefination",plugin = "pretty")
@CucumberOptions(features = "src/test/java/features",glue = "stepDefination"
,plugin = "pretty",tags="@DeletePlace")
public class TestRunner {

	 //1st comment from eclipse
	 //3rd comment from github
	
}

