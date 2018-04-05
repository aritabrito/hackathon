package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.model.User;

public interface UserDao {

    boolean authenticate(Integer id);

    User getAccessingUser();
}
