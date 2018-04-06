package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.model.products.Category;
import org.academiadecodigo.hackathon.persistence.jpa.JpaSessionManager;

public class JpaCategoryDao extends JpaAbstractDao {

    public JpaCategoryDao(JpaSessionManager sessionManager) {
        super(sessionManager, Category.class);
    }
}
