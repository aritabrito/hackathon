package org.academiadecodigo.hackathon.service.jpa;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.persistence.dao.Dao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.hackathon.service.UserService;

public class JpaUserService extends AbstractJpaService<User> implements UserService {
    public JpaUserService(JpaTransactionManager tm, Dao<User> dao) {
        super(tm, dao);
    }

    public boolean getAcessingUser(){



    }

}
