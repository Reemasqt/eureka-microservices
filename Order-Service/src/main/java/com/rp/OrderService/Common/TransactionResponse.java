package com.rp.OrderService.Common;

import com.rp.OrderService.Entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private Order order;
    private String transactionId;
    private String orderPrice;
    private String message;
}
