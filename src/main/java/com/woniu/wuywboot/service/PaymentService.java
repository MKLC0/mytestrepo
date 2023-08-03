package com.woniu.wuywboot.service;


import com.woniu.wuywboot.QO.PaymentQO;
import com.woniu.wuywboot.entity.Payment;
import com.woniu.wuywboot.utils.PageBean;

public interface PaymentService {
    PageBean<Payment> selectAll(PaymentQO paymentQO, Integer page);
    void add(Payment payment);
}
