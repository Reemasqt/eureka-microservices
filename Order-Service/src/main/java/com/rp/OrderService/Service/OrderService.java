package com.rp.OrderService.Service;

import com.rp.OrderService.Common.Payment;
import com.rp.OrderService.Common.TransactionRequest;
import com.rp.OrderService.Common.TransactionResponse;
import com.rp.OrderService.Entity.Order;
import com.rp.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

   @Autowired
    OrderRepository orderRepository;

   @Autowired
   RestTemplate restTemplate;

   String paymentStatus=" ";
   public TransactionResponse bookOrder(TransactionRequest transactionRequest){
       Order order=transactionRequest.getOrder();
       Payment payment = transactionRequest.getPayment();
       payment.setOrderId(order.getOrderId());
       payment.setOrderPrice(order.getOrderPrice());

       //Rest call
      Payment paymentResponse=restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
       paymentStatus =paymentResponse.getPaymentStatus().equalsIgnoreCase("success") ? "Successful" : "Fail";
        orderRepository.save(order);
       return  new TransactionResponse(order,paymentResponse.getTransactionId(), paymentResponse.getOrderPrice(),paymentStatus);
    }
}
