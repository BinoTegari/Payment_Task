package com.example.payment_task.service;

import com.example.payment_task.exceptions.InvalidAuthorizationException;
import com.example.payment_task.model.PaymentDto;
import com.example.payment_task.model.PaymentResponseDto;
import com.example.payment_task.service.client.PaymentFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {
    private final String rightToken = "Bearer cAmmvalAikARkB81fgxgMtnMbEdNbuWa";
    private final PaymentFeignClient paymentFeignClient;
    public String createPayment(PaymentDto paymentDto, String bearer){
        if(rightToken.equals(bearer)){
            PaymentDto payment = new PaymentDto();
            payment.setPaymentType(paymentDto.getPaymentType());
            payment.setCurrency(paymentDto.getCurrency());
            payment.setAmount(paymentDto.getAmount());
            var response = paymentFeignClient.getResponse(payment, bearer);
            return response.getReturnUrl();
        }
        throw new InvalidAuthorizationException("Authorization failed");
    }
}
