package br.com.sosa.dao;

import br.com.sosa.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class GenericDao<E> {
    private EntityManager entityManager = HibernateUtil.getEntityManager();

    public void save(E entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public E updateMerge(E entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        E entitySave = entityManager.merge(entity);
        transaction.commit();
        return entitySave;
    }

    public E search(E entity) {
        Object id = HibernateUtil.getPrimaryKey(entity);
        E e = (E) entityManager.find(entity.getClass(), id);
        return e;
    }

    public void deleteById(E entity) {
        Object id = HibernateUtil.getPrimaryKey(entity);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.createNativeQuery("DELETE FROM " + entity.getClass().getSimpleName().toLowerCase()
                + " WHERE id=" + id).executeUpdate();
        transaction.commit();
    }

    public List<E> searchAllUsers(Class<E> entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<E> list = entityManager.createQuery("FROM " + entity.getName()).getResultList();
        transaction.commit();

        return list;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}