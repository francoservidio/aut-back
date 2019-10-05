package org.zetaconsulting.eyetracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zetaconsulting.eyetracking.dao.RedesPrivadaDAO;
import org.zetaconsulting.eyetracking.model.RedesPrivada;

import java.util.List;

@RestController

public class RedesPrivadaController {

    @Autowired
    private RedesPrivadaDAO redesPrivadaDAO;

    @RequestMapping(value="/redesprivadas", method= RequestMethod.POST,
            produces="application/json", consumes="application/json")
    public void createRedesPrivada(@RequestBody RedesPrivada redesPrivada)
    {
        redesPrivadaDAO.createRedesPrivada(redesPrivada);
    }

    @RequestMapping(value="/redesprivadas/{id}",produces="application/json",
            method=RequestMethod.GET)
    public RedesPrivada getRedesPrivadaById(@PathVariable("id") long id)
    {
        RedesPrivada redesPrivada = redesPrivadaDAO.getRedesPrivadaById(id);
        return redesPrivada;
    }

    @RequestMapping(value="/redesprivadas",produces="application/json",
            method=RequestMethod.GET)
    public List<RedesPrivada> getAllRedesPrivada()
    {
        List<RedesPrivada> redesPrivadaList = redesPrivadaDAO.getAllRedesPrivada();
        return redesPrivadaList;
    }

    @RequestMapping(value="/redesprivadas", method=RequestMethod.PUT,
            produces="application/json", consumes="application/json")
    public RedesPrivada updateredesPrivada (@RequestBody RedesPrivada redesPrivada)
    {
        return redesPrivadaDAO.updateRedesPrivada(redesPrivada);
    }


    @RequestMapping(value="/redesprivadas/{id}/delete",produces="application/json")
    public void deleteredesPrivada(@PathVariable("id") long id)
    {
        redesPrivadaDAO.deleteRedesPrivada(id);
    }



}
