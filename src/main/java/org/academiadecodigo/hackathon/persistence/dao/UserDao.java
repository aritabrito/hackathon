package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.products.Product;

import java.util.List;

public interface UserDao {


    User getUserbyName(String name);

    List<Product> getUserProducts(User user);


}
