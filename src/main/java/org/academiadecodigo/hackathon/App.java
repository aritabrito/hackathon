package org.academiadecodigo.hackathon;

import org.academiadecodigo.hackathon.model.products.Category;
import org.academiadecodigo.hackathon.model.products.Product;

public class App {

    public static void main(String[] args) {

        Category category = new Category();
        category.setName("alimento");

        Product product = new Product();
        product.setName("milho");

        category.addProduct(product);
    }
}
