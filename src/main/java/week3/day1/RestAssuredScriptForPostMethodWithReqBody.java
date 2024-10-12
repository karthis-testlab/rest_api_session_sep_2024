package week3.day1;

import static io.restassured.RestAssured.given;

import com.google.gson.Gson;

import io.restassured.http.Header;

public class RestAssuredScriptForPostMethodWithReqBody {
	
	public static void main(String[] args) {

		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		String payload = """
				{
								
				    "description": "Call Post MEthod with request payload",
				    "short_description": "RESTAPISEP2024",
				    "state": "1",
				    "urgency": "1"
				}
								""";
		
		Incident incident = new Incident();
		incident.setDescription("Call Post MEthod with request payload");
		incident.setShort_description("RESTAPISESSIONSEP2024");
		
		given()
		  .auth()
		  .basic("admin", "vW0eDfd+A0V-")
		  .pathParam("tableName", "incident")
		  .header(new Header("Content-Type", "application/json"))
		  .log().all()
		  .when()
		  .body(new Gson().toJson(incident))
		  .post(url)
		  .then()
		  .log().all()
		  .assertThat()
		  .statusCode(201);
		
		System.out.println("Successfully incident was created!");

	}

}