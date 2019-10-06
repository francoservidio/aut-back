package org.serviconsulting.aut;

import org.serviconsulting.aut.dao.RedesPrivadaDAOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AutApplication {

	public static final String REST_BASE_URI = "http://localhost:8080/aut-api/";

	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(AutApplication.class, args);
		RedesPrivadaDAOImpl redesPrivadaDAO = new RedesPrivadaDAOImpl();

		List<Long> devices = new ArrayList<>();
		devices.add(new Long(161));
		redesPrivadaDAO.connectToDevices(devices,new Long(3800));
	}
}
