package org.example.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author matchfu
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "-----PaymentFallbackService fall back ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "-----PaymentFallbackService fall back ,o(╥﹏╥)o";
    }
}
