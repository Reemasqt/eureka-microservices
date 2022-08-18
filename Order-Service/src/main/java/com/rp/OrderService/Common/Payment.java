package com.rp.OrderService.Common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Long paymentId;

    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private String orderPrice;
}
