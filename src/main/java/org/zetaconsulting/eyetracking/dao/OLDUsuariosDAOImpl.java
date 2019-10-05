package org.zetaconsulting.eyetracking.dao;

import org.springframework.stereotype.Service;
import org.zetaconsulting.eyetracking.model.OLDUsuarios;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OLDUsuariosDAOImpl implements OLDUsuariosDAO {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void createUsuario(OLDUsuarios usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public OLDUsuarios getUsuarioById(Long id) {
        return entityManager.find(OLDUsuarios.class, id);
    }

    @Override
    public List<OLDUsuarios> getAllUsuarios() {
        return entityManager.createQuery("select usr from Usuarios usr").getResultList();
    }

    @Override
    public void updateUsuario(OLDUsuarios usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        OLDUsuarios usr = entityManager.find(OLDUsuarios.class, id);
        entityManager.remove(usr);
    }
}
