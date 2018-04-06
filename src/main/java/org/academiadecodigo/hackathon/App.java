package org.academiadecodigo.hackathon;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.hackathon.controller.LoginController;
import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.products.Category;
import org.academiadecodigo.hackathon.model.products.Product;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaCategoryDao;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaProductDao;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaUserDao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaSessionManager;
import org.academiadecodigo.hackathon.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.hackathon.service.*;
import org.academiadecodigo.hackathon.service.jpa.JpaAuthenticateLogin;
import org.academiadecodigo.hackathon.service.jpa.JpaCategoryService;
import org.academiadecodigo.hackathon.service.jpa.JpaProductService;
import org.academiadecodigo.hackathon.service.jpa.JpaUserService;

public class App extends Application {

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);

        navigation.loadView(LoginController.getName());

        primaryStage.setTitle("login");
        primaryStage.show();
    }


}
