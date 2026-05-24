package com.example.payment.service.impl;

import com.example.payment.annotation.RequireManagerApproval;
import com.example.payment.annotation.RequireOtp;
import com.example.payment.dto.PaymentRequest;
import com.example.payment.dto.RefundRequest;
import com.example.payment.entity.Transaction;
import com.example.payment.repository.ITransactionRepository;
import com.example.payment.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {

    private final ITransactionRepository transactionRepository;

    @Override
    public void processDomesticPayment(PaymentRequest request) {

        Transaction transaction = Transaction.builder()
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .type("DOMESTIC")
                .build();

        transactionRepository.save(transaction);
    }

    @Override
    @RequireOtp
    public void processInternationalPayment(PaymentRequest request) {

        Transaction transaction = Transaction.builder()
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .type("INTERNATIONAL")
                .build();

        transactionRepository.save(transaction);
    }

    @Override
    @RequireManagerApproval
    public void processRefund(RefundRequest request) {

        Transaction transaction = Transaction.builder()
                .transactionCode(request.getTransactionCode())
                .amount(request.getAmount())
                .type("REFUND")
                .build();

        transactionRepository.save(transaction);
    }
}