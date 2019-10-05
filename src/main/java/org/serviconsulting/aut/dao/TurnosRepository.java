package org.serviconsulting.aut.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.serviconsulting.aut.model.Turno;

import java.util.Date;
import java.util.List;

public interface TurnosRepository extends JpaRepository<Turno, Integer> {

    List<Turno> findAllByFechaTurno(Date fechaTurno);

/*    void createTurno(Turno turno);*/

}
