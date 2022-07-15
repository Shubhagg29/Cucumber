package testrunnners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		  features= {"src/test/resources/parallel/LoginPage.feature"},
		  glue= {"parallel"},
		  plugin= {"pretty",
				  "json:target/MyReports/report.json",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				     "rerun:target/rerun.txt"},
		  publish= true
		 
		)
public class MyTestRunner {

}
