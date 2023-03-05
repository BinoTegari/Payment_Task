package com.example.payment_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDto {
    public Result result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Result {
        private String redirectUrl;
        private String currency;
        private long amount;
        private String state;
        private String paymentType;
        private String id;
    }

}
