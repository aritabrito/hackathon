package org.academiadecodigo.hackathon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.academiadecodigo.hackathon.Navigation;
import org.academiadecodigo.hackathon.service.AuthenticateLogin;
import org.academiadecodigo.hackathon.service.ServiceRegistry;
import org.academiadecodigo.hackathon.service.UserService;
import org.academiadecodigo.hackathon.service.jpa.JpaAuthenticateLogin;
import org.academiadecodigo.hackathon.service.jpa.JpaUserService;

public class LoginController extends AbstractController implements Controller {

    public static final String NAME = "login";

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Pane login;


    @FXML
    private Label message;

    private JpaAuthenticateLogin authenticate;

    private JpaUserService userService;






        @FXML
        void onLogin(MouseEvent event) {
            doLogin();
        }




    @FXML
    public void initialize() {

        message.setText("");


        userService = (JpaUserService) ServiceRegistry.getServiceRegistry().getService(UserService.class.getSimpleName());
        authenticate = (JpaAuthenticateLogin) ServiceRegistry.getServiceRegistry().getService(AuthenticateLogin.class.getSimpleName());

        if (userService == null || authenticate == null) {
            throw new IllegalStateException("Unable to load user service from registry.");
        }


    }

    private void doLogin() {

        if (username.getText().isEmpty()) {
            message.setText("username missing");
            return;
        }

        if (password.getText().isEmpty()) {
            message.setText("password missing");
            return;
        }

        if (!authenticate.authenticateLogin(
                username.getText(), password.getText())) {
            message.setText("authentication failed");
            return;
        }

        message.setText("login accepted");

        Navigation.getInstance().loadView(MainMenuController.getName());
    }

    public static String getName() {
        return NAME;
    }
}
