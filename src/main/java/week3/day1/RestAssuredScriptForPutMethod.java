package week3.day1;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;


public class RestAssuredScriptForPutMethod {

	public static void main(String[] args) {
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}/{sysId}";
		
		Map<String, String> path_params = new HashMap<>();
		path_params.put("tableName", "incident");
		path_params.put("sysId", "166d41fd83099a10695bc7b6feaad372");
		
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		given()
		   .auth()
		   .basic("admin", "vW0eDfd+A0V-")
		   .pathParams(path_params)
		   .headers(headers)
		   .log().all()
	    .when()	        
	       .put(url)
	    .then()
	        .log().all()
	        .assertThat()
	        .statusCode(200);
		
		System.out.println("Successfully incident was updated!");
		   

	}

}