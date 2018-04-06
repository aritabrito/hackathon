package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.model.products.Product;
import org.academiadecodigo.hackathon.persistence.dao.ProductDao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaSessionManager;

public class JpaProductDao extends JpaAbstractDao implements ProductDao {

    public JpaProductDao(JpaSessionManager sessionManager) {

        super(sessionManager, Product.class);
    }
}
