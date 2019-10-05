package org.serviconsulting.aut.dao;

import org.serviconsulting.aut.model.RedesPrivada;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RedesPrivadaDAOImpl implements RedesPrivadaDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createRedesPrivada(RedesPrivada redesPrivada) {
        entityManager.persist(redesPrivada);
        entityManager.flush();
    }

    @Override
    public RedesPrivada getRedesPrivadaById(Long id) {
        return entityManager.find(RedesPrivada.class, id);
    }

    @Override
    public List<RedesPrivada> getAllRedesPrivada() {
        return entityManager.createQuery("select red from RedesPrivada red").getResultList();
    }

    @Override
    public RedesPrivada updateRedesPrivada(RedesPrivada redesPrivada) {
        entityManager.merge(redesPrivada);
        return redesPrivada;
    }

    @Override
    public void deleteRedesPrivada(Long id) {
        RedesPrivada redesPrivada = entityManager.find(RedesPrivada.class, id);
        entityManager.remove(redesPrivada);
    }



}
