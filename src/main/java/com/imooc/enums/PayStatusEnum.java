package com.imooc.enums;

import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
public enum PayStatusEnum implements  CodeEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;
    private Integer code;
    private  String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
