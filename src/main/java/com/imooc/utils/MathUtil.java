package com.imooc.utils;

/*
支付金额对比
2021-1-30 11:50
 */
public class MathUtil {
    private  static  final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1,Double d2){
        Double result = Math.abs(d1-d2);
        if(result<MONEY_RANGE){
            return true;
        }else{
            return false;
        }
    }
}
