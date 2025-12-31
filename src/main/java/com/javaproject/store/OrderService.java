package com.javaproject.store;

public class OrderService {
    private PaymentService paymentService;

//    public OrderService(PaymentService paymentService){
//        this.paymentService = paymentService;
//    }
    public void placeOrder(){
        paymentService.processPayment(200);
    }
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
