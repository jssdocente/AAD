package com.iesvi.repos.generic.jpa;

import com.iesvi.repos.generic.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GenericRepositoryJPA<T,K> implements GenericRepository<T,K> {

    private EntityManager em;

    private Class<T> type;

    public GenericRepositoryJPA(Class<T> type) {
        this.type = type;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public T findOne(K pk) {
        return em.find(type,pk);
    }

    public Iterable<T> findAll() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<T> query = cb.createQuery(type);

        Root<T> root = query.from(type);
        TypedQuery<T> queryExecute = em.createQuery(query);

        return queryExecute.getResultList();
    }

    public T save(T tipo) {
        em.persist(tipo); //vemos como acepta sin problema el tipo generico
        return tipo;
    }

    public void delete(T tipo) {
        em.remove(tipo); //vemos como acepta sin problema el tipo generico
    }
}
