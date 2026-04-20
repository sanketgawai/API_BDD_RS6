package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/java/features",glue = "stepDefination",plugin = "pretty")
@CucumberOptions(features = "src/test/java/features",glue = "stepDefination"
,plugin = "pretty",tags="@DeletePlace")
public class TestRunner {

<<<<<<< HEAD
	//git first change
	//git 2nd change from branch Sanket
=======
	 //1st comment from eclipse
>>>>>>> dc107f728ef0dc177d21c456d11059ed1c4ae7e1
}

