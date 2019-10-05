/*package org.zetaconsulting.eyetracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zetaconsulting.eyetracking.dao.OLDUsuariosDAO;
import org.zetaconsulting.eyetracking.model.OLDUsuarios;

import java.util.List;

@RestController
public class OLDUsuariosController {

    @Autowired
    private OLDUsuariosDAO usuariosDAO;

    @RequestMapping(value="/usuarios", method= RequestMethod.POST,
            produces="application/json", consumes="application/json")
    public void createUsuario(@RequestBody OLDUsuarios usuario) {
        usuariosDAO.createUsuario(usuario);
    }

    @RequestMapping(value="/usuarios/{id}",produces="application/json",
            method=RequestMethod.GET)
    public OLDUsuarios getUsuariosById(@PathVariable("id") long id) {
        OLDUsuarios usuario = usuariosDAO.getUsuarioById(id);
        return usuario;
    }

    @RequestMapping(value="/usuarios",produces="application/json",
            method=RequestMethod.GET)
    public List<OLDUsuarios> getAllUsuarios()
    {
        List<OLDUsuarios> usuarios = usuariosDAO.getAllUsuarios();
        return usuarios;
    }

    @RequestMapping(value="/usuarios", method=RequestMethod.PUT,
            produces="application/json", consumes="application/json")
    public void updateUsuario(@RequestBody OLDUsuarios usuario)
    {
        usuariosDAO.updateUsuario(usuario);
    }

    @RequestMapping(value="/usuarios/{id}",produces="application/json")
    public void deleteUsuario(@PathVariable("id") long id)
    {
        usuariosDAO.deleteUsuario(id);
    }

}
*/
