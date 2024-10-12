package week4.day1.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@failed-test.txt"},
        glue = {"week4.day1.step.definitions"},
        dryRun = false,
        plugin = {
      		    "html:reports/result.html", 
      		    "pretty",
      		    "rerun:failed-test.txt"
      		  }
      )
public class ReRunFailedTest extends AbstractTestNGCucumberTests {

}
