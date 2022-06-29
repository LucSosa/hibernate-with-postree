package br.com.sosa.dao;

import br.com.sosa.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDao<E> {
    private EntityManager entityManager = HibernateUtil.getEntityManager();
    public void salvar(E entity){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }
}
