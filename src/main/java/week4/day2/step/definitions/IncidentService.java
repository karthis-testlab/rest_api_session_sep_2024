package week4.day2.step.definitions;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.hamcrest.Matchers;

import com.google.gson.Gson;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import week4.day2.runners.IncidentPojoSerialization;

public class IncidentService {
	
	IncidentPojoSerialization pojo =  new IncidentPojoSerialization();
	Response response;
	
	@Given("set the base path of the service now incident table")
	public void set_the_base_path_of_the_service_now_incident_table() {
		basePath = "/api/now/table/{tableName}";
	}

	@When("/^send the post request for the incident service to create one record with (.*) short description$/")
	public void send_the_post_request_for_the_incident_service_to_create_one_record_with_restapisep2024_short_description(String arg) {
		pojo.setShort_description(arg);
	}

	@When("/^send the post request for the incident service to create record with (.*) description$/")
	public void send_the_post_request_for_the_incident_service_to_create_one_record_with_rest_api_post_call_description(String arg) {
		pojo.setDescription(arg);
		response = given() 
		    .header("Content-Type", "application/json")
		    .pathParam("tableName", "incident")
		    .log().all()
		.when()
		     .body(new Gson().toJson(pojo))
		     .post();
	}

	@Then("ensure the record successfully create")
	public void ensure_the_record_successfully_create(DataTable dataTable) {
		List<List<String>> cells = dataTable.cells();
		for (int i = 1; i < cells.size(); i++) {
			response.then()
	        .assertThat()
	        .statusCode(Integer.parseInt(cells.get(i).get(0)))
	        .statusLine(Matchers.containsString(cells.get(i).get(1)))
	        .contentType(cells.get(i).get(2));
		}
	}

}