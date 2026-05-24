package com.example.payment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RefundRequest {

    @NotBlank
    @Pattern(
            regexp = "^TXN[0-9]+$",
            message = "Invalid transaction code"
    )
    private String transactionCode;

    @NotNull
    private Double amount;
}