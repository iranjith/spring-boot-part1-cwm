package com.javaproject.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

        public static void main(String[] args) {
            ApplicationContext context= SpringApplication.run(StoreApplication.class, args);
            var userService=context.getBean(UserService.class);

            userService.registerUser(new User(1, "mosh@codewithmosh.com", "12345", "Mosh"));
            userService.registerUser(new User(1, "mosh@codewithmosh.com", "12345", "Mosh"));

    //        var orderService= new OrderService();
    //        orderService.setPaymentService(new PayPalPaymentService());
    //        orderService.placeOrder();

            //SpringApplication.run(StoreApplication.class, args);
        }

}
