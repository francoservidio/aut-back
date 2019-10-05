package org.serviconsulting.aut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.serviconsulting.aut.dao.TurnosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.serviconsulting.aut.dao.TurnosDAO;
import org.serviconsulting.aut.model.Turno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AutApplication.class)
public class AutApplicationTests {

	@Autowired
	private TurnosDAO turnosDAO;

	@Autowired
	private TurnosRepository repository;


	@Test
	public void contextLoads() throws ParseException {


		List<Turno> turnos = repository.findAllByFechaTurno(new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-24"));

		String a = "";
	}
}
