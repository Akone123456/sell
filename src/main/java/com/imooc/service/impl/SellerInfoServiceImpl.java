package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.repository.SellerInfoRepository;
import com.imooc.service.SellerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private  SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpneid(String openid) {
        SellerInfo result = sellerInfoRepository.findByOpenid(openid);
        return result;
    }
}
