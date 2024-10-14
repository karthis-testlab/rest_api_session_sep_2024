package week4.day1.step.definitions;

import static io.restassured.RestAssured.*;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class IncidentService {
	
	private Response response;	

	@Given("set the base path of the service now incident table")
	public void set_the_base_path_of_the_service_now_incident_table() {
		basePath = "/api/now/table/{tableName}";
	}	

	@When("send the post request for the incident service to create one record")
	public void send_the_post_request_for_the_incident_service_to_create_one_record() {
		response = given().pathParam("tableName", "/incident")
				          .header("Content-Type", "application/json")
				          .when().post();
	}
	
	@When("send the post request for the incident service to create one record with body {string}")
	public void send_the_post_request_for_the_incident_service_to_create_one_record_with_body(String requestPayload) {
		response = given().pathParam("tableName", "/incident")
		          .header("Content-Type", "application/json")		          
		          .when()
		          .body(requestPayload)
		          .post();
	}

	@Then("ensure the record successfully create with status code of {int}")
	public void ensure_the_record_successfully_create_with_status_code_of(Integer code) {
		response.then().assertThat().statusCode(code);
	}
	
	@Then("ensure the record successfully create")
	public void ensure_the_record_successfully_create(DataTable dataTable) {
	    List<List<String>> cells = dataTable.cells();
	    for (int i = 1; i < cells.size(); i++) {
			System.out.println(cells.get(i).get(0));
			System.out.println(cells.get(i).get(1));
		}
	}
	
	@When("send the post request for the incident service to create one record with RESTAPISEP2024 short description")
	public void send_the_post_request_for_the_incident_service_to_create_one_record_with_restapisep2024_short_description() {
	    
	}
	@When("When send the post request for the incident service to create one record with Rest API Post call description")
	public void when_send_the_post_request_for_the_incident_service_to_create_one_record_with_rest_api_post_call_description() {
	    
	}

}