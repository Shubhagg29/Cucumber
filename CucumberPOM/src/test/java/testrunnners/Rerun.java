package testrunnners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		  features= {"@target/rerun.txt"},
		  glue= {"parallel"},
		  plugin= {"pretty",
				  "json:target/MyReports/report.json",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				     "rerun:target/rerun.txt"},
		  publish= true
		 
		)
public class Rerun {

}
