package com.rp.PaymentService.Repository;

import com.rp.PaymentService.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Random;

public interface PaymentRepository extends JpaRepository<Payment, Long> {


    Payment findByorderId(Long orderId);
}
