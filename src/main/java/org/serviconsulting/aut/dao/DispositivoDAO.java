package org.serviconsulting.aut.dao;

import org.serviconsulting.aut.model.Dispositivo;

import java.util.List;

public interface DispositivoDAO {

    public void createDispositivo(Dispositivo dispositivo);

    public Dispositivo getDispositivoById(Long id);

    public List<Dispositivo> getAllDispositivos();

    public Dispositivo updateDispositivo(Dispositivo dispositivo);

    public void deleteDispositivo(Long id);

    public void backupDevices(String host);

    public boolean isReachable( String host);

}
