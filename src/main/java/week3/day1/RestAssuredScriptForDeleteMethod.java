package week3.day1;

import static io.restassured.RestAssured.*;

public class RestAssuredScriptForDeleteMethod {

	public static void main(String[] args) {
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}/{sysId}";
		
		given()
		   .auth()
		   .basic("admin", "vW0eDfd+A0V-")
		   .pathParam("tableName", "incident")
		   .pathParam("sysId", "166d41fd83099a10695bc7b6feaad372")
		   .log().all()
		.when()
		   .delete(url)
		.then()
		   .log().all()
		   .assertThat()
		   .statusCode(204);

	}

}