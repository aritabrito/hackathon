package org.academiadecodigo.hackathon.service.jpa;

import org.academiadecodigo.hackathon.model.AbstractModel;
import org.academiadecodigo.hackathon.persistence.TransactionException;
import org.academiadecodigo.hackathon.persistence.dao.Dao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.hackathon.service.CRUDService;

import java.util.List;


public abstract class AbstractJpaService<T extends AbstractModel> implements CRUDService<T> {

    protected JpaTransactionManager tm;
    protected Dao<T> dao;

    public AbstractJpaService(JpaTransactionManager tm, Dao<T> dao) {
        this.tm = tm;
        this.dao = dao;
    }

    @Override
    public List<T> list() {

        List<T> list = null;
        tm.beginRead();

        try {
            list = dao.findAll();
        } catch (TransactionException e) {
            tm.rollback();
        }

        return list;
    }

    @Override
    public T get(Integer id) {

        T toReturn = null;
        tm.beginRead();

        try {
            toReturn = dao.findById(id);
        } catch (TransactionException e) {
            tm.rollback();
        }
        return toReturn;
    }

    @Override
    public T save(T modelObject) {

        T toReturn = null;
        tm.beginWrite();

        try {
            toReturn = dao.saveOrUpdate(modelObject);
            tm.commit();
        } catch (TransactionException e) {
            tm.rollback();
        }
        return toReturn;
    }

    @Override
    public void delete(Integer id) {

        tm.beginWrite();

        try {
            dao.delete(id);
            tm.commit();
        } catch (TransactionException e) {
            tm.rollback();
        }
    }
}
