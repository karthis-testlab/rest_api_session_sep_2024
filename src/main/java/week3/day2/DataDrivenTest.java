package week3.day2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import week3.day1.Incident;

public class DataDrivenTest {
	
	@DataProvider
	public String[][] getData() {
		return new String[][] {
			{"Call Post MEthod with request payload 1", "RESTAPISESSION2024 - 1", "1", "1"},
			{"Call Post MEthod with request payload 2", "RESTAPISESSION2024 - 2", "1", "1"},
			{"Call Post MEthod with request payload 3", "RESTAPISESSION2024 - 3", "1", "1"},
			{"Call Post MEthod with request payload 4", "RESTAPISESSION2024 - 4", "1", "1"},
			{"Call Post MEthod with request payload 5", "RESTAPISESSION2024 - 5", "1", "1"}
		};
	}
	
	@Test(dataProvider = "getData")
	public void createNewIncident(String description, String shortDescription, String state, String urgency) {
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";

		Incident incident = new Incident();
		incident.setDescription(description);
		incident.setShort_description(shortDescription);
		incident.setState(state);
		incident.setUrgency(urgency);

		given().auth().basic("admin", "vW0eDfd+A0V-").pathParam("tableName", "incident")
				.header(new Header("Content-Type", "application/json")).log().all().when().body(incident).post(url)
				.then().log().all().assertThat().statusCode(201);

		System.out.println("Successfully incident was created!");
		
	}

}