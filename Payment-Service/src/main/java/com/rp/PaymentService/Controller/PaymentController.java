package com.rp.PaymentService.Controller;

import com.rp.PaymentService.Entity.Payment;
import com.rp.PaymentService.Repository.PaymentRepository;
import com.rp.PaymentService.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody  Payment payment){
        return paymentService.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment paymentHistoryByOrderId(@PathVariable("orderId") Long orderId){
        return paymentService.findByorderId(orderId);
    }
}
