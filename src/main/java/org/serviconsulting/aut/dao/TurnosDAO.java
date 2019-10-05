package org.serviconsulting.aut.dao;

import org.serviconsulting.aut.model.Turno;

import java.util.Date;
import java.util.List;

public interface TurnosDAO {

    List<Turno> retrieveTurnosByDate(Date date);

    void createTurno(Turno turno);

    void deleteTurno(Long id);
}
