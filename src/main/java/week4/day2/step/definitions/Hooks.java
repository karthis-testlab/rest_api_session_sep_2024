package week4.day2.step.definitions;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void runBeforeEachScenarios() {	
		baseURI = "https://dev262949.service-now.com";
		authentication = basic("admin", "vW0eDfd+A0V-");		
	}

}