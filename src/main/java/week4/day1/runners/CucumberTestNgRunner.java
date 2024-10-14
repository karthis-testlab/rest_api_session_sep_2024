package week4.day1.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/main/java/week4/day1/features/incident.feature"},
		          glue = {"week4.day1.step.definitions"},
		          dryRun = false,
		          plugin = {
		        		    "html:reports/result.html", 
		        		    "pretty",
		        		    "rerun:failed-test.txt"
		        		  },
		          tags = "@debug"
		        )
public class CucumberTestNgRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel = true)
    public Object[][] scenarios() {
		return super.scenarios();		
	}

}