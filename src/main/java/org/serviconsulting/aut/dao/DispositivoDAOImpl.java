package org.serviconsulting.aut.dao;

import org.springframework.stereotype.Service;
import org.serviconsulting.aut.model.Dispositivo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DispositivoDAOImpl implements DispositivoDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createDispositivo(Dispositivo dispositivo) {
        entityManager.persist(dispositivo);
        entityManager.flush();
    }

    @Override
    public Dispositivo getDispositivoById(Long id) {
        return entityManager.find(Dispositivo.class, id);
    }

    @Override
    public List<Dispositivo> getAllDispositivos() {
        return entityManager.createQuery("select dis from Dispositivo dis").getResultList();
    }

    @Override
    public Dispositivo updateDispositivo(Dispositivo dispositivo) {
        entityManager.merge(dispositivo);
        return dispositivo;
    }

    @Override
    public void deleteDispositivo(Long id) {
        Dispositivo dispositivo = entityManager.find(Dispositivo.class, id);
        entityManager.remove(dispositivo);
    }
}
