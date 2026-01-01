package com.javaproject.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }
    @PostConstruct
    public void init(){
        System.out.println("OrderService PostConstruct created");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("OrderService PreDestroy created");
    }

    public void placeOrder(){
        paymentService.processPayment(200);
    }
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
