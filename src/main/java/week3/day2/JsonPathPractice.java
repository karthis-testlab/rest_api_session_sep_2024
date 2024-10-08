package week3.day2;

import java.util.List;

import org.hamcrest.Matchers;
import org.hamcrest.MatcherAssert;

import io.restassured.path.json.JsonPath;

public class JsonPathPractice {

	public static void main(String[] args) {
		
		String json = """
								{
				    "firstName": "John",
				    "lastName": "doe",
				    "age": 26,
				    "address": {
				        "streetAddress": "naist street",
				        "city": "Nara",
				        "postalCode": "630-0192"
				    },
				    "phoneNumbers": [
				        {
				            "type": "iPhone",
				            "number": "0123-4567-8888"
				        },
				        {
				            "type": "home",
				            "number": "0123-4567-8910"
				        },
				        {
				            "type": "home",
				            "number": "0123-4567-8915"
				        },
				        {
                            "type": "home",
                            "number": "0123-4567-9000"
                        }
				    ]
				}
								""";
		
		JsonPath jsonPath = new JsonPath(json);
		List<String> numbers = jsonPath.getList("phoneNumbers.findAll{ it.type == 'home' }.number");
		
		MatcherAssert.assertThat(numbers, Matchers.hasItems("0123-4567-8910","0123-4567-8915","0123-4567-9000"));
		

	}

}