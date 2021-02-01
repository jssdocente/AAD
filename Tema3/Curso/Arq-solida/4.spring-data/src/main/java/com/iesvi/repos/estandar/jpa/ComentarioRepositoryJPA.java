package com.iesvi.repos.estandar.jpa;

import com.iesvi.bo.Comentario;
import com.iesvi.repos.estandar.ComentarioRepository;

import javax.persistence.EntityManager;

public class ComentarioRepositoryJPA implements ComentarioRepository {

    private EntityManager em;

    public Comentario findOne(int id) {
        return em.find(Comentario.class,id);
    }

    public Iterable<Comentario> findAll() {
        return em.createQuery("Select c from Comentario c").getResultList();
    }

    public void save(Comentario comentario) {
        em.persist(comentario);
    }

    public void delete(Comentario comentario) {
        em.remove(comentario);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

}
