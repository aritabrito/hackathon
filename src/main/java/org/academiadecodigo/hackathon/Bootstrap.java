package org.academiadecodigo.hackathon;

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

public class Bootstrap {

    public void init(){

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

    }
}
