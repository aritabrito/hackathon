package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.products.Product;

import java.util.List;

public interface UserService extends Service {

    void addProduct(User user, Product product);

    List<Product> userProductList(User user);

}
