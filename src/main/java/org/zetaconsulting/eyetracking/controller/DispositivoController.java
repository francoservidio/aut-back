package org.zetaconsulting.eyetracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zetaconsulting.eyetracking.dao.DispositivoDAO;
import org.zetaconsulting.eyetracking.model.Dispositivo;

import java.util.List;

@RestController
public class DispositivoController {

    @Autowired
    private DispositivoDAO dispositivoDAO;

    @RequestMapping(value="/dispositivos", method= RequestMethod.POST,
            produces="application/json", consumes="application/json")
    public void createDispositivo(@RequestBody Dispositivo dispositivo)
    {
        dispositivoDAO.createDispositivo(dispositivo);
    }

    @RequestMapping(value="/dispositivos/{id}",produces="application/json",
            method=RequestMethod.GET)
    public Dispositivo getDispositivoById(@PathVariable("id") long id)
    {
        Dispositivo dispositivo = dispositivoDAO.getDispositivoById(id);
        return dispositivo;
    }

    @RequestMapping(value="/dispositivos",produces="application/json",
            method=RequestMethod.GET)
    public List<Dispositivo> getAllDispositivos()
    {
        List<Dispositivo> dispositivoList = dispositivoDAO.getAllDispositivos();
        return dispositivoList;
    }

    @RequestMapping(value="/dispositivos", method=RequestMethod.PUT,
            produces="application/json", consumes="application/json")
    public Dispositivo updateDispositivo (@RequestBody Dispositivo dispositivo)
    {
        return dispositivoDAO.updateDispositivo(dispositivo);
    }


    @RequestMapping(value="/dispositivos/{id}/delete",produces="application/json")
    public void deleteDispositivo(@PathVariable("id") long id)
    {
        dispositivoDAO.deleteDispositivo(id);
    }


}
