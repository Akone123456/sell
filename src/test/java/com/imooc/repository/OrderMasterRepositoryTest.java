package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private  OrderMasterRepository repository;

    private  final String OPENID = "110110";
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("刘新伟");
        orderMaster.setBuyerPhone("19876234567");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result =repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
     @Test
    public void findByBuyerOpenid() {

         PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderMaster> orderMasterPage =  repository.findByBuyerOpenid(OPENID,pageRequest);
        Assert.assertNotEquals(0,orderMasterPage.getTotalElements());

    }
}