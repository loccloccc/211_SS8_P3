package com.example.payment.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.payment.annotation.RequireOtp;

@Aspect
@Component
@RequiredArgsConstructor
public class OtpSecurityAspect {

    private final HttpServletRequest request;

    @Before("@annotation(requireOtp)")
    public void validateOtp(
            RequireOtp requireOtp
    ) {

        String otp = request.getHeader("X-OTP");

        if (!"123456".equals(otp)) {
            throw new RuntimeException("Invalid OTP");
        }
    }
}