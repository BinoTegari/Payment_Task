package com.example.payment_task.model;

import com.example.payment_task.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private PaymentType paymentType;
    private long amount;
    private String currency;
}
