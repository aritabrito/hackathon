package org.academiadecodigo.hackathon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import org.academiadecodigo.hackathon.Navigation;
import org.academiadecodigo.hackathon.service.ProductService;



public class MainMenuController extends AbstractController {

    public static final String NAME = "main-menu";
    public static final String NEXT = "products";

    private ProductService productService;
    private ProductsController nextController;


    @FXML
    void onAnimalsClick(MouseEvent event) {

        String musicFile = "/sound/soundFx.wav";
        AudioClip audioClip = new AudioClip(getClass().getResource(musicFile).toExternalForm());
        audioClip.play();
        Navigation.getInstance().loadView(ProductsController.getName());
    }


    @FXML
    private MenuItem buy;

    @FXML
    private MenuItem cart;

    @FXML
    private MenuItem logout;

    @FXML
    private MenuItem about;

    @FXML
    private ImageView catOne;

    @FXML
    private ImageView catTwo;

    @FXML
    private ImageView catThree;

    @FXML
    void onAbout(ActionEvent event) {

    }

    @FXML
    void onBuy(ActionEvent event) {

    }

    @FXML
    void onCart(ActionEvent event) {

    }


    @FXML
    void onCatOneClick(MouseEvent event) {

        //Navigation.getInstance().loadView(ProductsController.getName());
    }

    @FXML
    void onCatTwoClick(MouseEvent event) {
        //Navigation.getInstance().loadView(ProductsController.getName());
    }

    @FXML
    void onCatThreeClick(MouseEvent event) {
        //Navigation.getInstance().loadView(ProductsController.getName());
    }

    @FXML
    void onLogout(ActionEvent event) {
        //Navigation.getInstance().back();
    }

    public static String getName() {
        return NAME;
    }
}
