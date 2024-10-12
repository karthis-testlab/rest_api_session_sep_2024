package week3.day2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	
	private String number;
	private String sys_id;
	private String short_description;
	private String description;
	private String category;

}