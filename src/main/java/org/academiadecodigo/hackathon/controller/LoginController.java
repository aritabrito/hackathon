package org.academiadecodigo.hackathon.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.academiadecodigo.hackathon.service.UserService;

import java.awt.event.ActionEvent;

public class LoginController extends AbstractController implements Controller {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Label message;



    @FXML
    void onLogin(ActionEvent event) {

    }

    public void initialize() {

    }


}
