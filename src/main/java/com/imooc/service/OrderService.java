package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.imooc.repository.OrderDetailRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/*
买家端-订单-service-创建订单
2021-1-22 12:20
 */
public interface OrderService {

    /*
    创建订单
     */

    OrderDTO create(OrderDTO orderDTO);

    /* 查询某个订单 */
    OrderDTO findOne(String orderId);

    /*查询订单列表 并分页  买家端查看自己所购买的订单，不能查看所有*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /*取消订单 */
    OrderDTO cancel (OrderDTO orderDTO);

    /* 完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /* 支付订单 */
    OrderDTO paid (OrderDTO orderDTO);



    /*查询订单列表 并分页  卖家端查看所有的订单/

     */
    Page<OrderDTO> findList( Pageable pageable);
}
