package com.example.payment_task.controller;

import com.example.payment_task.model.PaymentDto;
import com.example.payment_task.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public String createPayment(@RequestBody PaymentDto paymentDto, @RequestHeader ("Authorization") String bearer){
        paymentService.createPayment(paymentDto, bearer);
        return paymentService.createPayment(paymentDto, bearer);
    }
}
