package com.example.payment_task.service.client;

import com.example.payment_task.model.PaymentDto;
import com.example.payment_task.model.PaymentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://app-demo.paze.eu/api/v1", name = "paymentService",
        configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface PaymentFeignClient {
    @PostMapping("/payments")
    PaymentResponseDto getResponse(@RequestBody PaymentDto paymentDto, @RequestHeader("Authorization") String bearer);

}
