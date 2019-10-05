package org.serviconsulting.aut.controller;

import org.serviconsulting.aut.dao.UsuariosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.serviconsulting.aut.model.Usuarios;

import java.util.List;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosDAO usuariosDAO;

    @RequestMapping(value="/usuarios", method= RequestMethod.POST,
            produces="application/json", consumes="application/json")
    public void createUsuarios(@RequestBody Usuarios usuarios)
    {
        usuariosDAO.createUsuarios(usuarios);
    }

    @RequestMapping(value="/usuarios/{id}",produces="application/json",
            method=RequestMethod.GET)
    public Usuarios getUsuariosById(@PathVariable("id") long id)
    {
        Usuarios usuarios  = usuariosDAO.getUsuariosById(id);
        return usuarios;
    }


    @RequestMapping(value="/usuarios",produces="application/json",
            method=RequestMethod.GET)
    public List<Usuarios> getAllUsuarios()
    {
        List<Usuarios> usuariosList = usuariosDAO.getAllUsuarios();
        return usuariosList;
    }


    @RequestMapping(value="/usuarios", method=RequestMethod.PUT,
            produces="application/json", consumes="application/json")
    public Usuarios updateUsuarios (@RequestBody Usuarios usuarios)
    {
        return usuariosDAO.updateUsuarios(usuarios);
    }


    @RequestMapping(value="/usuarios/{id}/delete",produces="application/json")
    public void deleteUsuarios(@PathVariable("id") long id)
    {
        usuariosDAO.deleteUsuarios(id);
    }






}
