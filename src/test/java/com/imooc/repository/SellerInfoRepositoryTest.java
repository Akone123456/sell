package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;
import com.imooc.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private  SellerInfoRepository sellerInfoRepository;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("lxw");
        sellerInfo.setPassword("123456");
        sellerInfo.setOpenid("abc");
        SellerInfo  result= sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOpenid() {

        SellerInfo result = sellerInfoRepository.findByOpenid("abc");
        Assert.assertNotNull(result);
    }
}