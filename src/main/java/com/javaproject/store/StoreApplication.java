package com.javaproject.store;

import com.javaproject.store.entities.User;
import com.javaproject.store.repositories.UserRepository;
import com.javaproject.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

        public static void main(String[] args) {
            ApplicationContext context= SpringApplication.run(StoreApplication.class, args);

            var service= context.getBean(UserService.class);
            service.fetchProducts();


//            service.updateProductPrices();
//            service.fetchProducts();
//            service.fetchUsers();

            //service.manageProducts();
//            service.persistRelated();
//            service.deleteRelated();
//            service.fetchAddresses(var);

//            var repository= context.getBean(UserRepository.class);
//
//            var user= User.builder()
//                    .name("johndoe")
//                    .email("johndoe@gmail.com")
//                    .password("password")
//                    .build();
//
//
//            repository.save(user);



        }

}
