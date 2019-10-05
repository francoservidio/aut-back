package org.serviconsulting.aut.dao;

import org.serviconsulting.aut.model.EstudiosVigentes;

import java.util.List;

public interface EstudiosVigentesDAO {

    public void createEstudioVigente(EstudiosVigentes estudiosVigente);

    public EstudiosVigentes getEstudioVigenteById(Long id);

    public List<EstudiosVigentes> getAllEstudiosVigentes();

    public void updateEstudiosVigentes(EstudiosVigentes estudiosVigente);

    public void deleteEstudiosVigentes(Long id);

}
