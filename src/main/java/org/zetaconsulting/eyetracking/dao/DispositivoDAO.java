package org.zetaconsulting.eyetracking.dao;

import org.zetaconsulting.eyetracking.model.Dispositivo;

import java.util.List;

public interface DispositivoDAO {

    public void createDispositivo(Dispositivo dispositivo);

    public Dispositivo getDispositivoById(Long id);

    public List<Dispositivo> getAllDispositivos();

    public Dispositivo updateDispositivo(Dispositivo dispositivo);

    public void deleteDispositivo(Long id);

}
