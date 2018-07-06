package om.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/om/feature",
		glue="om.stepdefiniton",
		tags= {"@f1,@f2"}
		)
public class TestRunner {

}
