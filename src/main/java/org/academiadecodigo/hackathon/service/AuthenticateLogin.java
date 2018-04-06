package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.User;

public interface AuthenticateLogin {

    boolean authenticateLogin(String username, String password);

    User getAcessingUser();

}
