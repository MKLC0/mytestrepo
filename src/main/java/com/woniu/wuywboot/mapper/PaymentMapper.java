package com.woniu.wuywboot.mapper;


import com.woniu.wuywboot.QO.PaymentQO;
import com.woniu.wuywboot.entity.Payment;

import java.util.List;

public interface PaymentMapper {
    List<Payment> select(PaymentQO paymentQO);
    void add(Payment payment);
}
