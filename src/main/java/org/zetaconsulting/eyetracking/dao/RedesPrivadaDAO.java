package org.zetaconsulting.eyetracking.dao;

import org.zetaconsulting.eyetracking.model.RedesPrivada;

import java.util.List;

public interface RedesPrivadaDAO {

    public void createRedesPrivada(RedesPrivada redesPrivada);

    public RedesPrivada getRedesPrivadaById(Long id);

    public List<RedesPrivada> getAllRedesPrivada();

    public RedesPrivada updateRedesPrivada(RedesPrivada redesPrivada);

    public void deleteRedesPrivada(Long id);

}
