package week3.day2;

import static io.restassured.RestAssured.given;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.response.Response;

public class ValidateGetAllIncidentRecords {

	public static void main(String[] args) {

		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		Response response = given()
		                      .auth()
		                      .basic("admin", "vW0eDfd+A0V-")
		                      .pathParam("tableName", "incident")
		                      .log().all()
		                    .when()		      
		                       .get(url);
		
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getStatusLine(), Matchers.containsString("OK"));
		
		Results[] results = response.getBody().jsonPath().getObject("result", Results[].class);
		
		System.out.println(results.length);
		
		for (Results result : results) {
			System.out.println(result.getCategory());
		}

	}

}
