package week6.day2;

import org.json.JSONObject;

import io.restassured.RestAssured;

public class GitHubGraphQL {

	public static void main(String[] args) {
		
		String url = "https://api.github.com/graphql";
		
		String query = """
								query {
				  viewer {
				    login
				    name
				    followers {
				      totalCount
				    }
				    repositories {
				      totalCount
				    }
				  }
				}
								""";
		
		RestAssured.given()
		           .header("Authorization", "Bearer ")
		           .log().all()
		           .when()
		           .body(convertQueryToJsonString(query))
		           .post(url)
		           .then()
		           .log().all();
		           

	}
	
	public static String convertQueryToJsonString(String query) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("query", query);
		return jsonObject.toString();
	}

}
