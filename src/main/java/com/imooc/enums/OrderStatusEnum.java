package com.imooc.enums;


import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Getter;

/*
2021-1-21 22:31
 */
@Getter
public enum  OrderStatusEnum implements CodeEnum {
    NEW(0,"新下单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
                ;

    private  Integer code;
    private  String msg;

     OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
