package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.products.Product;
import org.academiadecodigo.hackathon.persistence.SessionManager;
import org.academiadecodigo.hackathon.persistence.TransactionException;
import org.academiadecodigo.hackathon.persistence.dao.UserDao;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaAbstractDao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaSessionManager;
import org.hibernate.HibernateException;

import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaUserDao extends JpaAbstractDao implements UserDao {

    public JpaUserDao(JpaSessionManager jpaSessionManager) {

        super(jpaSessionManager, User.class);
    }


    @Override
    public User saveOrUpdate(User user) {
        try {
            System.out.println(user);
            sessionManager.getEntityManager().merge(user);
            return user;
        } catch (RollbackException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public User getUserbyName(String name) {

        try {


            CriteriaBuilder builder = sessionManager.getEntityManager().getCriteriaBuilder();

            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

            Root<User> root = criteriaQuery.from(User.class);

            criteriaQuery.select(root);

            criteriaQuery.where(builder.equal(root.get("name"), name));

            return sessionManager.getEntityManager().createQuery(criteriaQuery).getSingleResult();
        }catch (HibernateException ex){
            throw new TransactionException(ex);
        }
    }

    @Override
    public List<Product> getUserProducts(User user) {

    return null;

    }

}

