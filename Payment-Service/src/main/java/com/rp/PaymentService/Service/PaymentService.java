package com.rp.PaymentService.Service;

import com.rp.PaymentService.Entity.Payment;
import com.rp.PaymentService.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return  paymentRepository.save(payment);
    }

    public String paymentProcessing(){
        return new Random().nextBoolean() ? "Success" : "Failed";
    }

    public Payment findByorderId(Long orderId){
        return  paymentRepository.findByorderId(orderId);
    }
}
