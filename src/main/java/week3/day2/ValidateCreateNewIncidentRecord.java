package week3.day2;

import static io.restassured.RestAssured.given;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class ValidateCreateNewIncidentRecord {

	public static void main(String[] args) {
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";

		String payload = """
				{

				    "description": "Call Post Method with request payload",
				    "short_description": "RESTAPISEP2024",
				    "state": "1",
				    "urgency": "1"
				}
								""";

		Response response = given().auth().basic("admin", "vW0eDfd+A0V-").pathParam("tableName", "incident")
				.header(new Header("Content-Type", "application/json")).log().all().when().body(payload).post(url);		
		
		System.out.println(response.asPrettyString());
		
		Result result = response.getBody().jsonPath().getObject("result", Result.class);
		
		System.out.println(result.getSys_id());
		System.out.println(result.getNumber());
		
		MatcherAssert.assertThat("Call Post Method with request payload", Matchers.equalTo(result.getDescription()));
		MatcherAssert.assertThat("RESTAPISEP2024", Matchers.equalTo(result.getShort_description()));
		
		System.out.println("Successfully incident was created!");
	}
}
