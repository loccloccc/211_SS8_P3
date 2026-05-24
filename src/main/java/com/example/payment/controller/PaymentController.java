package com.example.payment.controller;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.dto.RefundRequest;
import com.example.payment.service.IPaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final IPaymentService paymentService;

    @PostMapping("/domestic")
    public String domesticPayment(
            @Valid @RequestBody PaymentRequest request
    ) {

        paymentService.processDomesticPayment(request);

        return "Domestic payment success";
    }

    @PostMapping("/international")
    public String internationalPayment(
            @Valid @RequestBody PaymentRequest request
    ) {

        paymentService.processInternationalPayment(request);

        return "International payment success";
    }

    @PostMapping("/refund")
    public String refund(
            @Valid @RequestBody RefundRequest request
    ) {

        paymentService.processRefund(request);

        return "Refund success";
    }
}