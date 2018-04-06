package org.academiadecodigo.hackathon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.academiadecodigo.hackathon.controller.Controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Navigation {

    public static final String VIEW_PATH = "/view";
    private static Navigation instance;
    private LinkedList<Scene> scenes = new LinkedList<>();
    private Map<String, Controller> controllerMap = new HashMap<>();
    private Stage stage;

    public Navigation() {
    }

    public static Navigation getInstance() {

        if (instance == null) {
            instance = new Navigation();
        }
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Controller getController(String view) {
        return controllerMap.get(view);
    }

    public void loadView(String view) {

        Parent root = null;

        try {

            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);

            scenes.push(scene);
            setScene(scene);

            controllerMap.put(view, fxmlLoader.<Controller>getController());

        } catch (IOException e) {
            System.out.println("Failure to load view "+ view + " : " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void back() {

        if (scenes.isEmpty()) {
            return;
        }

        scenes.pop();
        setScene(scenes.peek());
    }

    private void setScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    private void close() {
        stage.close();
    }

}

