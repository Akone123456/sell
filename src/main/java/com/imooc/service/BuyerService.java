package com.imooc.service;

import com.imooc.dto.OrderDTO;

/*

买家查看订单详情与取消的Service
判断是否为当前用户
2021-1-23 15:57
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
