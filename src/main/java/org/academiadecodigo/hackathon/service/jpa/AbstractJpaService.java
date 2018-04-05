package org.academiadecodigo.hackathon.service.jpa;

import org.academiadecodigo.hackathon.model.AbstractModel;

import org.academiadecodigo.hackathon.persistence.dao.Dao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.hackathon.service.CRUDService;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public abstract class AbstractJpaService<T extends AbstractModel> implements CRUDService {

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

        try{
            list= dao.findAll;

        }

    }

    @Override
    public T get(Integer id) {
        return null;
    }

    @Override
    public T save(AbstractModel modelObject) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
