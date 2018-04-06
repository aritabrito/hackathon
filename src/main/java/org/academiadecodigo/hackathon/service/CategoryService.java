package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.products.Category;

import java.util.List;

public interface CategoryService extends Service {

    List<Category> categories();
}
