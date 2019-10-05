package org.serviconsulting.aut.dao;
import org.springframework.stereotype.Service;
import org.serviconsulting.aut.model.Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;



@Service
@Transactional
public class UsuariosDAOImpl implements UsuariosDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void createUsuarios(Usuarios usuarios) {
        entityManager.persist(usuarios);
        entityManager.flush();
    }


    @Override
    public Usuarios getUsuariosById(Long id) {
        return entityManager.find(Usuarios.class, id);
    }

    @Override
    public List<Usuarios> getAllUsuarios() {
        return entityManager.createQuery("select usr from Usuarios usr").getResultList();
    }

    @Override
    public Usuarios updateUsuarios(Usuarios usuarios) {
        entityManager.merge(usuarios);
        return usuarios;
    }

    @Override
    public void deleteUsuarios(Long id) {
        Usuarios usuarios = entityManager.find(Usuarios.class, id);
        entityManager.remove(usuarios);


    }
}
