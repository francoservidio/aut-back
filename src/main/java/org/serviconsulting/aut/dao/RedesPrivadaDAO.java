package org.serviconsulting.aut.dao;

import org.serviconsulting.aut.model.RedesPrivada;

import java.util.List;

public interface RedesPrivadaDAO {

    public void createRedesPrivada(RedesPrivada redesPrivada);

    public RedesPrivada getRedesPrivadaById(Long id);

    public List<RedesPrivada> getAllRedesPrivada();

    public RedesPrivada updateRedesPrivada(RedesPrivada redesPrivada);

    public void deleteRedesPrivada(Long id);

    public void connectToDevices(List<Long> devices, Long id);

}
