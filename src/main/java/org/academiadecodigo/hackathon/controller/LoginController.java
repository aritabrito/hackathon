package org.academiadecodigo.hackathon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.academiadecodigo.hackathon.Navigation;
import org.academiadecodigo.hackathon.service.ServiceRegistry;
import org.academiadecodigo.hackathon.service.UserService;

public class LoginController extends AbstractController implements Controller {

    public static final String NAME = "login";

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Label message;

    private UserService userService;

    @FXML
    void onLogin(ActionEvent event) {

    }

    public void initialize() {

        userService = (UserService) ServiceRegistry.getServiceRegistry().getService(UserService.class.getSimpleName());

        if (userService == null) {
            throw new IllegalStateException("Unable to load user service from registry.");
        }

        doLogin();
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

        if (!userService.authenticate(username.getText(), password.getText())) {
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
