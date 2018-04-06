package org.academiadecodigo.hackathon.service.jpa;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.products.Product;
import org.academiadecodigo.hackathon.persistence.TransactionException;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaUserDao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.hackathon.service.UserService;

import java.util.List;


public class JpaUserService extends AbstractJpaService<User> implements UserService {

    private JpaUserDao userDao;

    public JpaUserService(JpaTransactionManager tm, JpaUserDao dao) {
        super(tm, dao);
        this.userDao = dao;
    }


    @Override
    public List<Product> userProductList(User user) {

        List<Product> productList = null;

        return productList = user.getProductsList();
    }

    @Override
    public void addProduct(User user, Product product) {

        tm.beginWrite();
        try {
            user.addProduct(product);
            dao.saveOrUpdate(user);

        } catch (TransactionException ex) {
            tm.rollback();
        }
    }

}
