package com.imooc.VO;

import lombok.Data;

import java.io.Serializable;

/*
http请求返回的最外层对象
2021-1-21 15:14
 */
@Data
public class ResultVO<T> implements Serializable {


    private static final long serialVersionUID = 3068837394742385883L;
    /*
        错误码
         */
    private  Integer code;

    /*
    提示信息
     */
    private  String msg;


    /*
    具体内容
     */
    private T data;

}
