package org.serviconsulting.aut.dao;

import org.serviconsulting.aut.model.Pacientes;

import java.util.List;

public interface OLDPacientesDAO {

    public Pacientes getPacienteById(Long id);

    public List<Pacientes> getAllPacientes();

    public void updatePaciente(Pacientes pacientes);

    public void deletePaciente(Long id);
}
