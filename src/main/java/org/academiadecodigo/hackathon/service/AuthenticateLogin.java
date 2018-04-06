package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.User;

public interface AuthenticateLogin extends Service {

    boolean authenticateLogin(String username, String password);

    User getAcessingUser();

}
