package org.example.springcloud.service.impl;

import org.example.springcloud.dao.PaymentDao;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment queryById(Long id) {
        return paymentDao.queryById(id);
    }

    @Override
    public List<Payment> queryAllByLimit(int offset, int limit) {
        return paymentDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Payment> queryAll(Payment payment) {
        return paymentDao.queryAll(payment);
    }

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public int update(Payment payment) {
        return paymentDao.update(payment);
    }

    @Override
    public int deleteById(Long id) {
        return paymentDao.deleteById(id);
    }
}
