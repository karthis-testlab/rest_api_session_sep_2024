package week4.day2.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/main/java/week4/day2/features/incident.feature",
		          glue = "week4.day2.step.definitions",
		          dryRun = false,
		          monochrome = true,
		          plugin = {
		        		  "pretty",
		        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
		          }
		         )
public class IncidentTestRunner extends AbstractTestNGCucumberTests {

}