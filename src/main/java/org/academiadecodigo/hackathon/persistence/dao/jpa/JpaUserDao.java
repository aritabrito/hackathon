package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.persistence.dao.UserDao;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaAbstractDao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaSessionManager;

public class JpaUserDao extends JpaAbstractDao implements UserDao {

    public JpaUserDao(JpaSessionManager jpaSessionManager) {

        super(jpaSessionManager, User.class);
    }
}
