package week4.day1.step.definitions;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
	
	@Before
	public void runBeforeEachScenarios() {	
		baseURI = "https://dev262949.service-now.com";
		authentication = basic("admin", "vW0eDfd+A0V-");		
	}
	
	@After
	public void runAfterEachScenarios() {
		
	}
	
	@BeforeStep
	public void beforeStep() {
		
	}
	
	@AfterStep
	public void afterStep() {
		
	}

}