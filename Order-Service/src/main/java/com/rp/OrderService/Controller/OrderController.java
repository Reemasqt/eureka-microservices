package com.rp.OrderService.Controller;

import com.rp.OrderService.Common.Payment;
import com.rp.OrderService.Common.TransactionRequest;
import com.rp.OrderService.Common.TransactionResponse;
import com.rp.OrderService.Entity.Order;
import com.rp.OrderService.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){

        return orderService.bookOrder(transactionRequest);
    }

}
