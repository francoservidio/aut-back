package org.zetaconsulting.eyetracking.dao;

import org.zetaconsulting.eyetracking.model.OLDUsuarios;

import java.util.List;

public interface OLDUsuariosDAO {

    public void createUsuario(OLDUsuarios usuario);

    public OLDUsuarios getUsuarioById(Long id);

    public List<OLDUsuarios> getAllUsuarios();

    public void updateUsuario(OLDUsuarios usuario);

    public void deleteUsuario(Long id);

}
