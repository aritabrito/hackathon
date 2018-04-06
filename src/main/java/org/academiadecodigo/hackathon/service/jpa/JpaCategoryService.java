package org.academiadecodigo.hackathon.service.jpa;

import org.academiadecodigo.hackathon.model.products.Category;

import org.academiadecodigo.hackathon.persistence.TransactionException;
import org.academiadecodigo.hackathon.persistence.dao.Dao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.hackathon.service.CategoryService;

import java.util.List;

public class JpaCategoryService extends AbstractJpaService<Category> implements CategoryService {

    public JpaCategoryService(JpaTransactionManager tm, Dao<Category> dao) {
        super(tm, dao);
    }

    @Override
    public List<Category> categories() {

        List<Category> categories = null;

        tm.beginRead();

        try {
            categories =  dao.findAll();

        } catch (TransactionException ex) {
            tm.rollback();
        }
        return categories;
    }
}
