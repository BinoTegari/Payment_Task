package com.example.payment_task.service.client;

import com.example.payment_task.model.PaymentForm;
import com.example.payment_task.model.PaymentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "${feign.services.paymentService.url}", name = "paymentService",
        configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface PaymentFeignClient {
    @PostMapping("/payments")
    PaymentResponseDto getResponse(@RequestBody PaymentForm paymentForm, @RequestHeader("Authorization") String bearer);
}
