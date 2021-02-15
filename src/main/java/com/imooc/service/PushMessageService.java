package com.imooc.service;

import com.imooc.dto.OrderDTO;

/*
微信模板推送消息
2021-2-13 22:16
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
