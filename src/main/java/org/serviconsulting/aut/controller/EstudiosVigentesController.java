package org.serviconsulting.aut.controller;

import org.serviconsulting.aut.dao.EstudiosVigentesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.serviconsulting.aut.model.EstudiosVigentes;

import java.util.List;

@RestController
public class EstudiosVigentesController {

    @Autowired
    private EstudiosVigentesDAO estudiosVigentesDAO;

    @RequestMapping(value="/estudiosvigentes", method= RequestMethod.POST,
            produces="application/json", consumes="application/json")
    public void createEstudioVigente(@RequestBody EstudiosVigentes estudiosVigentes) {
        estudiosVigentesDAO.createEstudioVigente(estudiosVigentes);
    }

    @RequestMapping(value="/estudiosvigentes/{id}",produces="application/json",
            method=RequestMethod.GET)
    public EstudiosVigentes getEstudiosVigentesById(@PathVariable("id") long id) {
        EstudiosVigentes estudiosVigente = estudiosVigentesDAO.getEstudioVigenteById(id);
        return estudiosVigente;
    }

    @RequestMapping(value="/estudiosvigentes",produces="application/json",
            method=RequestMethod.GET)
    public List<EstudiosVigentes> getAllEstudiosVigentes()
    {
        List<EstudiosVigentes> estudiosVigentes = estudiosVigentesDAO.getAllEstudiosVigentes();
        return estudiosVigentes;
    }

    @RequestMapping(value="/estudiosvigentes", method=RequestMethod.PUT,
            produces="application/json", consumes="application/json")
    public void updateStudent(@RequestBody EstudiosVigentes estudiosVigente)
    {
        estudiosVigentesDAO.updateEstudiosVigentes(estudiosVigente);
    }

    @RequestMapping(value="/estudiosvigentes/{id}",produces="application/json")
    public void deleteCliente(@PathVariable("id") long id)
    {
        estudiosVigentesDAO.deleteEstudiosVigentes(id);
    }

}
