package org.academiadecodigo.hackathon.service.jpa;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.persistence.TransactionException;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaUserDao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.hackathon.service.AuthenticateLogin;

public class JpaAuthenticateLogin extends AbstractJpaService<User> implements AuthenticateLogin{

    private JpaUserDao userDao;
    private User acessingUser;

    public JpaAuthenticateLogin(JpaTransactionManager tm, JpaUserDao dao) {
        super(tm, dao);
        this.userDao= dao;
    }

    @Override
    public boolean authenticateLogin(String username, String password) {
        tm.beginRead();
        try{
          User user =  userDao.getUserbyName(username);
          if (user == null){
              return false;
          }
            if(user.getPassword().equals(password)){
              acessingUser = user;
              return true;
            }

        }catch (TransactionException ex){
            tm.rollback();
        }

        return false;
    }

    @Override
    public User getAcessingUser() {
        return acessingUser;

    }

}
