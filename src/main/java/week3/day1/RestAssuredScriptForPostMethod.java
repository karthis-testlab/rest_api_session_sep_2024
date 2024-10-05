package week3.day1;

import static io.restassured.RestAssured.*;

import io.restassured.http.Header;

public class RestAssuredScriptForPostMethod {

	public static void main(String[] args) {
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		given()
		  .auth()
		  .basic("admin", "vW0eDfd+A0V-")
		  .pathParam("tableName", "incident")
		  .header(new Header("Content-Type", "application/json"))
		  .log().all()
		  .when()
		  .post(url)
		  .then()
		  .log().all()
		  .assertThat()
		  .statusCode(201);
		
		System.out.println("Successfully incident was created!");
		

	}

}