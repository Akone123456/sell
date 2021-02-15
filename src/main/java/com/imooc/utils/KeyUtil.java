package com.imooc.utils;

import java.util.Random;

/*
买家端-订单-service-创建订单
生成随机订单号和订单详情号
 */
public class KeyUtil {
    /*
    生成唯一的逐渐
    格式:时间+随机数
     */
    public static  synchronized  String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }

}
