package com.javaproject.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

        public static void main(String[] args) {
            ApplicationContext context= SpringApplication.run(StoreApplication.class, args);
            context.getBean(OrderService.class).placeOrder();

    //        var orderService= new OrderService();
    //        orderService.setPaymentService(new PayPalPaymentService());
    //        orderService.placeOrder();

            //SpringApplication.run(StoreApplication.class, args);
        }

}
