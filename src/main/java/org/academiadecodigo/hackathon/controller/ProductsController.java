package org.academiadecodigo.hackathon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.academiadecodigo.hackathon.CategoryType;
import org.academiadecodigo.hackathon.model.Product;
import org.academiadecodigo.hackathon.service.ProductService;
import org.academiadecodigo.hackathon.service.ServiceRegistry;
import java.util.List;

public class ProductsController extends AbstractController {

    public static final String NAME = "products";
    private CategoryType categoryType;
    List<Product> products;

    private ProductService productService;

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

        List<Category> categories = getAllCategories(id);

        switch (categoryType) {
            case FOOD:
                productService.getList(1);
                break;
            case ANIMALS:
                productService.getList(2);
                break;
            case VEHICLES:
                productService.getList(3);
                break;
        }

    }



    @FXML
    void onDeleteButton(ActionEvent event) {

        productService = (ProductService) ServiceRegistry.getServiceRegistry().getService(ProductService.class.getSimpleName());

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
