package org.academiadecodigo.hackathon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.academiadecodigo.hackathon.CategoryType;
import org.academiadecodigo.hackathon.Navigation;
import org.academiadecodigo.hackathon.model.products.Category;
import org.academiadecodigo.hackathon.model.products.Product;
import org.academiadecodigo.hackathon.service.ProductService;
import org.academiadecodigo.hackathon.service.ServiceRegistry;
import org.academiadecodigo.hackathon.service.jpa.JpaCategoryService;
import org.academiadecodigo.hackathon.service.jpa.JpaProductService;

import java.util.LinkedList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ProductsController extends AbstractController {

    public static final String NAME = "products";
    private CategoryType categoryType;
    List<Product> products;

    private JpaProductService productService;
    private JpaCategoryService categoryService;

    public ProductsController() {

    }



        @FXML
        private Pane logout;

        @FXML
        void logout(MouseEvent event) {
            Navigation.getInstance().loadView("login");
        }






    @FXML
        private ImageView donkey;
    @FXML
    private ImageView cow;
    @FXML
    private ImageView chicken;
    @FXML
    private ImageView rabbit;
    @FXML
    private ImageView sheep;



    @FXML
    void donkeyClicked(MouseEvent event) {
        donkey.setVisible(false);
    }

    @FXML
    void cowClicked(MouseEvent event) {
        cow.setVisible(false);
    }

    @FXML
    void chickenClicked(MouseEvent event) {
        chicken.setVisible(false);
    }

    @FXML
    void rabbitClicked(MouseEvent event) {
        rabbit.setVisible(false);
    }

    @FXML
    void sheepClicked(MouseEvent event) {
        sheep.setVisible(false);
    }

    public static String getName() {
        return NAME;
    }
}
