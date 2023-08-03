package com.woniu.wuywboot.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.wuywboot.QO.PaymentQO;
import com.woniu.wuywboot.entity.Payment;
import com.woniu.wuywboot.mapper.PaymentMapper;
import com.woniu.wuywboot.service.PaymentService;
import com.woniu.wuywboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentMapper paymentMapper;
    @Override
    public PageBean<Payment> selectAll(PaymentQO paymentQO, Integer page) {
        Integer pageSize = 3;
        Page<Object> objects = PageHelper.startPage(page, pageSize);
        List<Payment> payments = paymentMapper.select(paymentQO);
        PageBean<Payment> paymentPageBean = new PageBean<>();
        paymentPageBean.setData(payments);
        paymentPageBean.setActualNum(payments.size());
        paymentPageBean.setPageSize(pageSize);
        paymentPageBean.setCurrPage(page);
        paymentPageBean.setTotalPage(objects.getPages());
        paymentPageBean.setTotalNums((int) objects.getTotal());
        return paymentPageBean;
    }

    @Override
    public void add(Payment payment) {
        paymentMapper.add(payment);
    }
}
