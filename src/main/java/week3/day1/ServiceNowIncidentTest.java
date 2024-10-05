package week3.day1;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ServiceNowIncidentTest extends BaseClass {	
	
	@Test
	public void validateUserAbleToGetAllIncidentRecords() {		
		given()
		   .pathParam("tableName", "incident")
		   .log().all()
		   .when()		      
		   .get()
		   .then()
		   .assertThat()
		   .statusCode(200);		
	}
	
	@Test	
	public void validateUserAbleToGetASingleIncidentRecord() {		
		given()
		   .pathParam("tableName", "incident")
		   .pathParams("sysId", "1c741bd70b2322007518478d83673af3")
		   .log().all()
		   .when()		      
		   .get("/{sysId}")
		   .then()
		   .assertThat()
		   .statusCode(200);
	}

}