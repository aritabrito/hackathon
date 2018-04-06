package org.academiadecodigo.hackathon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.academiadecodigo.hackathon.CategoryType;
import org.academiadecodigo.hackathon.model.products.Category;
import org.academiadecodigo.hackathon.model.products.Product;
import org.academiadecodigo.hackathon.service.ProductService;
import org.academiadecodigo.hackathon.service.ServiceRegistry;
import org.academiadecodigo.hackathon.service.jpa.JpaCategoryService;
import org.academiadecodigo.hackathon.service.jpa.JpaProductService;

import java.util.List;

public class ProductsController extends AbstractController {

    public static final String NAME = "products";
    private CategoryType categoryType;
    List<Product> products;

    private JpaProductService productService;
    private JpaCategoryService categoryService;

    public ProductsController() {

    }

    // se categoria 1 -> mostra prods 1
    // se categoria 2 -> mostra prods 2
    // se categoria 3 -> mostra prods 3


    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveButton;


    public void initialize() {

        categoryService = (JpaCategoryService) ServiceRegistry.getServiceRegistry().getService(ProductService.class.getSimpleName());

        List<Category> categories = categoryService.categories();

        switch (categoryType) {
            case FOOD:

                productService.productList(categories.get(1));

                break;
            case ANIMALS:
                productService.productList(categories.get(2));
                break;
            case VEHICLES:
                productService.productList(categories.get(3));
                break;
        }

    }



    @FXML
    void onDeleteButton(ActionEvent event) {

        productService = (JpaProductService) ServiceRegistry.getServiceRegistry().getService(ProductService.class.getSimpleName());

        if (productService == null) {
            throw new IllegalStateException("Unable to load user service from registry");
        }

    }

    @FXML
    void onSaveButton(ActionEvent event) {

    }

    public static String getName() {
        return NAME;
    }
}
