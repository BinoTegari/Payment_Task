package com.example.payment_task.service;

import com.example.payment_task.PaymentType;
import com.example.payment_task.exceptions.InvalidAuthorizationException;
import com.example.payment_task.model.PaymentForm;
import com.example.payment_task.service.client.PaymentFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentFeignClient paymentFeignClient;

    public String createPayment(PaymentForm paymentForm, String bearer) {
        String rightToken = "Bearer cAmmvalAikARkB81fgxgMtnMbEdNbuWa";
        if (rightToken.equals(bearer)) {
            PaymentForm payment = new PaymentForm();
            payment.setPaymentType(PaymentType.DEPOSIT);
            payment.setCurrency("EUR");
            payment.setAmount(paymentForm.getAmount());
            var result = ResponseEntity.ok(paymentFeignClient.getResponse(payment, bearer));
            var pageSuccess = result.getBody();
            assert pageSuccess != null;
            return pageSuccess.getResult().getRedirectUrl();
        }
        throw new InvalidAuthorizationException("Authorization failed");
    }

    public PaymentForm createPaymentForm() {
        PaymentForm paymentForm = new PaymentForm();
        paymentForm.setPaymentType(PaymentType.DEPOSIT);
        paymentForm.setCurrency("EUR");
        return paymentForm;
    }
}
