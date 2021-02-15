package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.utils.EnumUtil;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
dao层数据传输
2021-1-22 12:42
 */

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {


    /* 订单Id */

    private  String orderId;

    /* 买家姓名 */
    private  String buyerName;

    /* 买家电话 */
    private  String buyerPhone;

    /*买家地址  */
    private  String buyerAddress;

    /* 买家微信openid*/
    private  String buyerOpenid ;

    /*订单总金额 */
    private BigDecimal orderAmount;

    /*订单状态，0表示新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();


    /*支付状态，0表示未支付 */
    private  Integer payStatus = PayStatusEnum.WAIT.getCode();

    /*订单创建时间  */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /* 订单更新时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private  Date updateTime;

    /*订单列表的详细信息 */
    List<OrderDetail> orderDetailList ;


    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }


}
