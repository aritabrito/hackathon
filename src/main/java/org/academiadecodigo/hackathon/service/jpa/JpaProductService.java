package org.academiadecodigo.hackathon.service.jpa;

import org.academiadecodigo.hackathon.model.products.Category;
import org.academiadecodigo.hackathon.model.products.Product;
import org.academiadecodigo.hackathon.persistence.dao.Dao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.hackathon.service.ProductService;

import java.util.List;

public class JpaProductService extends AbstractJpaService<Product> implements ProductService {

    public JpaProductService(JpaTransactionManager tm, Dao<Product> dao) {

        super(tm, dao);
    }

    public List<Product> productList(Category category) {


    }
}