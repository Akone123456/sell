package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.service.SellerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerInfoServiceImplTest {

    @Autowired
    private SellerInfoServiceImpl sellerInfoService;

    public static  final String OPENID = "abc";

    @Test
    public void findSellerInfoByOpneid() {

        SellerInfo result = sellerInfoService.findSellerInfoByOpneid(OPENID);

        Assert.assertEquals(OPENID,result.getOpenid());

    }
}