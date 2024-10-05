package week3.day1;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*;

public class ServiceNowIncidentChainRequestTest extends BaseClass {
	
	@Test(priority = 0)
	public void createOneNewIncident() {
	sys_id = given()
		  .pathParam("tableName", "incident")
		  .header(new Header("Content-Type", "application/json"))
		  .log().all()
		.when()
		   .post()
		.then()		   
		   .assertThat()
		   .statusCode(201)
		   .statusLine(containsString("Created"))
		   .contentType(ContentType.JSON)
		   .extract()
		   .jsonPath()
		   .getString("result.sys_id");	
	}
	
	@Test(priority = 1)	
	public void validateUserAbleToGetASingleIncidentRecord() {		
		given()
		   .pathParam("tableName", "incident")
		   .pathParam("sysId", sys_id)
		   .log().all()
		   .when()		      
		   .get("/{sysId}")
		   .then()
		   .assertThat()
		   .statusCode(200)
		   .statusLine(containsString("OK"))
		   .contentType(ContentType.JSON)
		   .body("result.sys_id", equalTo(sys_id));
	}
	
	@Test(priority = 2)	
	public void updateExsitingIncidentRecord() {
		given()
		   .pathParam("tableName", "incident")
		   .pathParam("sysId", sys_id)
		   .header(new Header("Content-Type", "application/json"))
		   .log().all()
	    .when()	        
	       .put("/{sysId}")
	    .then()
	        .log().all()
	        .assertThat()
	        .statusCode(200)
	        .statusLine(containsString("OK"))
	        .contentType(ContentType.JSON);
	}
	
	@Test(priority = 3)	
	public void deleteExistingIncidenRecord() {
		given()
		   .pathParam("tableName", "incident")
		   .pathParam("sysId", sys_id)
		   .log().all()
		   .when()		      
		   .delete("/{sysId}")
		   .then()
		   .assertThat()
		   .statusCode(204)
		   .statusLine(containsString("No Content"));
	}
	
	@Test(priority = 4)	
	public void validateIsRecordSuccessfullyDeletedFormDatabase() {		
		given()
		   .pathParam("tableName", "incident")
		   .pathParam("sysId", sys_id)
		   .log().all()
		   .when()		      
		   .get("/{sysId}")
		   .then()
		   .assertThat()
		   .statusCode(404)
		   .statusLine(containsString("Not Found"))
		   .contentType(ContentType.JSON);
	}

}