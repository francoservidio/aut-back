package org.serviconsulting.aut.controller;

import org.serviconsulting.aut.dao.RedesPrivadaDAO;
import org.serviconsulting.aut.model.RedesPrivada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RedesPrivadaController {

    @Autowired
    private RedesPrivadaDAO redesPrivadaDAO;

    @RequestMapping(value="/redesprivadas/{id}/connect", method= RequestMethod.POST,
            produces="application/json", consumes="application/json")
    public void createRedesPrivada(@RequestBody List<Long> dispositivosIds, @PathVariable("id") long id)
    {
        redesPrivadaDAO.connectToDevices(dispositivosIds, id);
    }

    @RequestMapping(value="/redesprivadas/", method= RequestMethod.POST,
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
