package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    private final String BUYER_OPENID="1101110";

    private final String ORDER_ID = "1611298488530563339";

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("刘新伟");
        orderDTO.setBuyerPhone("19951753185");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123457");
        o1.setProductQuantity(2);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123458");
        o2.setProductQuantity(10);
        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO  result= orderService.create(orderDTO);

        log.info("【创建订单】 result={}"+result);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOne() {

        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询某个订单】 result={}" + result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());


    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,2);
       Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,pageRequest);

       Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test

    public void cancel() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        OrderDTO result = orderService.cancel(orderDTO);

        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        OrderDTO result = orderService.finish(orderDTO);

        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        OrderDTO result = orderService.paid(orderDTO);

        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }


    @Test
    public void list(){
        PageRequest pageRequest = new PageRequest(0,10);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        Assert.assertTrue("订单列表",orderDTOPage.getTotalElements()>0);
    }
}