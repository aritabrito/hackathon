package org.academiadecodigo.hackathon;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.hackathon.controller.LoginController;

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

        primaryStage.setTitle("OpportuniCorn");
        primaryStage.show();
    }


}
