package week2.day2;

import static io.restassured.RestAssured.*;

public class FirstRestAssuredScript {

	public static void main(String[] args) {
		
		// RestAssuresd is a Java Based library used to test the RESTful APIs (HTTP Protocol)
		// RestAssured structure is based on DSL
		// given() --> Pre-condintion for your HTTP Methods (Auth, header, query parameter, path parameter)
		// when() --> It's performing the HTTP method action (GET, POST, PUT, PATCH and DELETE) along with we also send request-payload
		// then() --> Assert the response (status-code, response body, response header)
		// RestAssured used Hamcrest package for the assertion
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		given()
		   .auth()
		   .basic("admin", "vW0eDfd+A0V-")
		   .pathParam("tableName", "incident")
		   .log().all()
		   .when()		      
		   .get(url)
		   .then()
		   .assertThat()
		   .statusCode(200);
		

	}

}