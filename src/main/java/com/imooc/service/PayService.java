package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import org.aspectj.weaver.ast.Or;

public interface PayService {

    //微信支付
    PayResponse create(OrderDTO orderDTO);
    //微信异步通知
    PayResponse notify(String notifyData);
    //微信退款
    RefundResponse refund(OrderDTO orderDTO);
}
