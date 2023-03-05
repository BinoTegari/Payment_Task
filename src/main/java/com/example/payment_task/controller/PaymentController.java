package com.example.payment_task.controller;

import com.example.payment_task.model.PaymentForm;
import com.example.payment_task.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@Controller
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public RedirectView createPayment(
            @RequestHeader(value = "Authorization",
                    defaultValue = "Bearer cAmmvalAikARkB81fgxgMtnMbEdNbuWa") String bearer,
            @ModelAttribute PaymentForm form) {
        String payment = paymentService.createPayment(form, bearer);
        return new RedirectView(payment);
    }

    @GetMapping("/start")
    public String create(Model model) {
        model.addAttribute("form", paymentService.createPaymentForm());
        return "payment";
    }
}
