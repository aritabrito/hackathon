package org.academiadecodigo.hackathon;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.hackathon.controller.LoginController;
import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.products.Category;
import org.academiadecodigo.hackathon.model.products.Product;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaCategoryDao;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaProductDao;
import org.academiadecodigo.hackathon.persistence.dao.jpa.JpaUserDao;
import org.academiadecodigo.hackathon.persistence.jpa.JpaSessionManager;
import org.academiadecodigo.hackathon.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.hackathon.service.*;
import org.academiadecodigo.hackathon.service.jpa.JpaAuthenticateLogin;
import org.academiadecodigo.hackathon.service.jpa.JpaCategoryService;
import org.academiadecodigo.hackathon.service.jpa.JpaProductService;
import org.academiadecodigo.hackathon.service.jpa.JpaUserService;

public class App extends Application {

    public static void main(String[] args) {

        User user1 = new User();
        user1.setFirstName("Catarina");
        user1.setLastName("Machado");
        user1.setUsername("catarinamachado");
        user1.setEmail("123");
        user1.setPassword("123");

        User user2 = new User();
        user2.setFirstName("cat");
        user2.setLastName("mach");
        user2.setUsername("cm");
        user2.setEmail("oi");
        user2.setPassword("oi");


        Category category1 = new Category();
        category1.setName("food");

        Category category2 = new Category();
        category2.setName("vehicles");

        Category category3 = new Category();
        category3.setName("animals");


        Product product1 = new Product();
        product1.setName("corn");

        Product product2 = new Product();
        product2.setName("tractor");

        Product product3 = new Product();
        product3.setName("sheep");

        category1.addProduct(product1);
        category1.addProduct(product2);
        category1.addProduct(product3);


        JpaSessionManager sessionManager = new JpaSessionManager();
        JpaTransactionManager transactionManager = new JpaTransactionManager(sessionManager);

        JpaUserDao userDao = new JpaUserDao(sessionManager);
        JpaProductDao productDao = new JpaProductDao(sessionManager);
        JpaCategoryDao jpaCategoryDao = new JpaCategoryDao(sessionManager);
        JpaUserService userService = new JpaUserService(transactionManager, userDao);
        JpaProductService productService = new JpaProductService(transactionManager, productDao);
        JpaCategoryService jpaCategoryService = new JpaCategoryService(transactionManager, jpaCategoryDao);


        JpaAuthenticateLogin jpaAuthenticateLogin = new JpaAuthenticateLogin(transactionManager, userDao);



        ServiceRegistry.getServiceRegistry().registerService(UserService.class.getSimpleName(), userService);
        ServiceRegistry.getServiceRegistry().registerService(CategoryService.class.getSimpleName(), jpaCategoryService);
        ServiceRegistry.getServiceRegistry().registerService(ProductService.class.getSimpleName(), productService);
        ServiceRegistry.getServiceRegistry().registerService(AuthenticateLogin.class.getSimpleName(), jpaAuthenticateLogin);



        userService.save(user1);
        userService.save(user2);
        jpaCategoryService.save(category1);
        jpaCategoryService.save(category2);
        jpaCategoryService.save(category3);


        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);

        navigation.loadView(LoginController.getName());

        primaryStage.setTitle("OpportuniCorn");
        primaryStage.show();
    }


}
