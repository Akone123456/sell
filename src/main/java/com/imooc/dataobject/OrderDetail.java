package com.imooc.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    private  String detailId;

    /* 订单Id  */
    private  String orderId;

    /* 商品Id*/
    private  String productId;

    /*商品名称 */
    private  String productName;

    /* 商品价格*/
    private BigDecimal productPrice;

    /* 商品数量 */
    private Integer productQuantity;

    /* 商品图片 */
    private  String productIcon;

    /*商品创建时间 */
    private Date createTime;

    /*商品更新时间  */
    private  Date updateTime;
}
