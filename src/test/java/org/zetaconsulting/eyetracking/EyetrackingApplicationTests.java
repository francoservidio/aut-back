package org.zetaconsulting.eyetracking;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zetaconsulting.eyetracking.dao.TurnosDAO;
import org.zetaconsulting.eyetracking.dao.TurnosRepository;
import org.zetaconsulting.eyetracking.model.Turno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EyetrackingApplication.class)
public class EyetrackingApplicationTests {

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
