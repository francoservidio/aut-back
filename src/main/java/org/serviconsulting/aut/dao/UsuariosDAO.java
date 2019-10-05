package org.serviconsulting.aut.dao;

import org.serviconsulting.aut.model.Usuarios;

import java.util.List;

public interface UsuariosDAO {


    public void createUsuarios(Usuarios usuarios);

    public Usuarios getUsuariosById(Long id);

    public List<Usuarios> getAllUsuarios();

    public Usuarios updateUsuarios(Usuarios usuarios);

    public void deleteUsuarios(Long id);
}
