package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author matchfu
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功，serverPort：" + serverPort, result);
        } else {
            return new CommonResult<>(444, "插入数据库失败，serverPort：" + serverPort, null);
        }
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        log.info("*****插入结果：" + payment);
        if (Objects.nonNull(payment)) {
            return new CommonResult<>(200, "查询成功，serverPort：" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应的记录，serverPort：" + serverPort + "，查询ID：" + id, null);
        }
    }

    @GetMapping("payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
