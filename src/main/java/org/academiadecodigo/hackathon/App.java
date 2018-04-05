package org.academiadecodigo.hackathon;

import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.products.Category;
import org.academiadecodigo.hackathon.model.products.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        Category category = new Category();
        category.setName("alimento");

        Category category1 = new Category();
        category1.setName("vehicles");

        Product product = new Product();
        product.setName("milho");

        Product product1 = new Product();
        product1.setName("tractor");

        User user = new User();


        category.addProduct(product);
        category1.addProduct(product1);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simone");
        EntityManager em = emf.createEntityManager();
        EntityManager em1 = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(category);
        em.persist(category1);
        em.persist(product);
        em.persist(product1);
        em.getTransaction().commit();
        em.close();

        user.addProduct(product);
        user.addProduct(product1);

        em1.getTransaction().begin();
        em1.persist(user);
        em1.getTransaction().commit();
        em1.close();

    }
}
