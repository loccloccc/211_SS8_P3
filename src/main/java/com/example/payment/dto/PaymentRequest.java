package com.example.payment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentRequest {

    @NotNull
    private Double amount;

    @NotNull
    private String currency;
}