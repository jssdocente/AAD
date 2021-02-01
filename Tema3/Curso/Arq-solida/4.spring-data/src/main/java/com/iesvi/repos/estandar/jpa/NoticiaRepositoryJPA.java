package com.iesvi.repos.estandar.jpa;

import com.iesvi.bo.Noticia;
import com.iesvi.repos.estandar.NoticiaRepository;

import javax.persistence.EntityManager;

public class NoticiaRepositoryJPA implements NoticiaRepository {

    EntityManager em;

    public Noticia findOne(int id) {
        return em.find(Noticia.class,id);
    }

    public Iterable<Noticia> findAll() {
       return em.createQuery("select n from Noticia n",Noticia.class).getResultList();
    }

    public void save(Noticia noticia) {
        em.persist(noticia);
    }

    public void delete(Noticia noticia) {
        em.remove(noticia);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
