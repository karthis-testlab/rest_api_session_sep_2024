package week6.day2;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.response.Response;

public class CookieHandlingInRestAssured {

	public static void main(String[] args) {
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		Response response = given()
		   .auth()
		   .basic("admin", "vW0eDfd+A0V-")
		   .pathParam("tableName", "incident")
		   .log().all()
		   .when()		      
		   .get(url);
		
		// Extract the cookies value from the response
		Map<String, String> cookies = response.getCookies();
		
		for (Entry<String, String> map : cookies.entrySet()) {
			System.out.println("Key: "+map.getKey());
			System.out.println("Value: "+map.getValue());
		}
		
		System.out.println(response.getCookie("JSESSIONID"));
		
		// Pass the JSESSIONID value to the following resquest
		
		given()	
		   .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
		   .pathParam("tableName", "incident")
		   .queryParam("sysparm_query", "category=hardware")
		   .queryParam("sysparm_fields", "sys_id,category,short_description,description")
		   .log().all()
		   .when()		      
		   .get(url)
		   .prettyPrint();
		

	}

}