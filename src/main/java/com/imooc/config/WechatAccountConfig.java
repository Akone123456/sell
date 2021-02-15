package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
微信支付配置
2021-1-25 17:14
 */
@Component
@Data
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {



    /*
    支付账号
     */

    private  String mpAppId;

    private  String mpAppSecret;

    /**
     * 开放平台id
     */
    private String openAppId;

    /**
     * 开放平台密钥
     */
    private String openAppSecret;
    /*
    商户号
     */
    private  String mchId;

    /*
    商户密钥
     */
    private  String mchKey;

    /*
    商户证书路径
     */
    private  String KeyPath;

    /*
    微信支付异步通知地址
     */
    private  String notifyUrl;


    /**
     * 微信模版id
     */
    private Map<String, String> templateId;

}
