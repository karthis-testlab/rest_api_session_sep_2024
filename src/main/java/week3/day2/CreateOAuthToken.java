package week3.day2;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class CreateOAuthToken {
	
	private String token;
	
	@Test
	public void createOAuthToken() {
		String url = "https://dev262949.service-now.com/oauth_token.do";
		token = given()
		  .header("Content-Type", "application/x-www-form-urlencoded")
		  .log().all()
		.when()
		  .formParam("grant_type", "password")
		  .formParam("client_id", "fb0e45e7c63852103a642e78381a32e7")
		  .formParam("client_secret", "BxSirL(Cp2")
		  .formParam("username", "admin")
		  .formParam("password", "vW0eDfd+A0V-")
		  .post(url)
		.then()
		  .log().all()
		  .extract()
		  .jsonPath()
		  .getString("access_token");	
		
		System.out.println(token);
		
	}
	
	
	@Test
	public void validateTheGetCallWithBearerToken() {
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		given()
		   .header("Authorization", "Bearer "+token)
		   .pathParam("tableName", "incident")
		   .log().all()
		   .when()		      
		   .get(url)
		   .then()
		   .assertThat()
		   .statusCode(200);
	}

}