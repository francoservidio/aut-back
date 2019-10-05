package org.zetaconsulting.eyetracking.dao;

import org.zetaconsulting.eyetracking.model.RedesPrivada;
import org.zetaconsulting.eyetracking.model.Usuarios;

import java.util.List;

public interface UsuariosDAO {


    public void createUsuarios(Usuarios usuarios);

    public Usuarios getUsuariosById(Long id);

    public List<Usuarios> getAllUsuarios();

    public Usuarios updateUsuarios(Usuarios usuarios);

    public void deleteUsuarios(Long id);
}
