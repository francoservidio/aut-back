package org.serviconsulting.aut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AutApplication {

	public static final String REST_BASE_URI = "http://localhost:8080/aut-api/";

	static RestTemplate restTemplate = new RestTemplate();



	public static void main(String[] args) {
		SpringApplication.run(AutApplication.class, args);
	}
}
