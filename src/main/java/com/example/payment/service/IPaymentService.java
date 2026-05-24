package com.example.payment.service;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.dto.RefundRequest;

public interface IPaymentService {

    void processDomesticPayment(PaymentRequest request);

    void processInternationalPayment(PaymentRequest request);

    void processRefund(RefundRequest request);
}