package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.model.Model;
import org.academiadecodigo.hackathon.persistence.SessionManager;
import org.academiadecodigo.hackathon.persistence.TransactionExcepiton;
import org.academiadecodigo.hackathon.persistence.dao.Dao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaSessionManager;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class JpaAbstractDao<T extends Model> implements Dao<T> {

    protected JpaSessionManager sessionManager;
    protected Class<T> modelType;


    public JpaAbstractDao(JpaSessionManager sessionManager, Class<T> modelType){
        this.modelType = modelType;
        this.sessionManager = sessionManager;
    }

    @Override
    public T findById(Integer id) {
        return sessionManager.getEntityManager().find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T model) {
        sessionManager.getEntityManager().merge(model);
        return model;
    }

    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = sessionManager.getEntityManager().getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);

        return sessionManager.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void delete(Integer id) {
        try {
            sessionManager.getEntityManager().remove(sessionManager.getEntityManager().find(modelType, id));
        }catch (HibernateException ex){
            throw new TransactionExcepiton(ex);
        }
    }
}
