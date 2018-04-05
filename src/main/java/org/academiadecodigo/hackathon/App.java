package org.academiadecodigo.hackathon;

import org.academiadecodigo.hackathon.model.products.Category;
import org.academiadecodigo.hackathon.model.products.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        Category category = new Category();
        category.setName("alimento");

        Product product = new Product();
        product.setName("milho");

        category.addProduct(product);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simone");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        em.close();

    }
}
