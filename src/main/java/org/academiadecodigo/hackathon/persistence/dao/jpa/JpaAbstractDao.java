package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.model.Model;
import org.academiadecodigo.hackathon.persistence.TransactionException;
import org.academiadecodigo.hackathon.persistence.dao.Dao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaSessionManager;
import org.hibernate.HibernateException;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class JpaAbstractDao<T extends Model> implements Dao<T> {

    protected JpaSessionManager sessionManager;
    protected Class<T> modelType;


    public JpaAbstractDao(JpaSessionManager sessionManager, Class<T> modelType) {
        this.modelType = modelType;
        this.sessionManager = sessionManager;
    }

    @Override
    public T findById(Integer id) {
        try {
            return sessionManager.getEntityManager().find(modelType, id);
        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public T saveOrUpdate(T model) {
        try {
            sessionManager.getEntityManager().merge(model);
            return model;
        } catch (RollbackException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public List<T> findAll() {

        try {
            CriteriaQuery<T> criteriaQuery = sessionManager.getEntityManager().getCriteriaBuilder().createQuery(modelType);
            Root<T> root = criteriaQuery.from(modelType);

            return sessionManager.getEntityManager().createQuery(criteriaQuery).getResultList();
        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            sessionManager.getEntityManager().remove(sessionManager.getEntityManager().find(modelType, id));
        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }
}
