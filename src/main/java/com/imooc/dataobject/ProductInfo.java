package com.imooc.dataobject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*
商品
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {


    private static final long serialVersionUID = 6399186181668983148L;
    @Id
    private String productId;

    /* 商品名称*/
    private String productName;

    /* 商品价格 */
    private BigDecimal productPrice;

    /*
    库存
     */
    private Integer productStock;

    /*
    商品描述
     */
    private String productDescription;


    /*
商品图片
     */
    private  String productIcon;


    /*
    商品状态  0正常，1下架
     */
    private  Integer productStatus = ProductStatusEnum.UP.getCode();

    /*
    商品编号
     */

    private Integer categoryType;


    /*
    创建时间
     */
    private Date createTime;

    /*
    更新时间
     */
    private  Date  updateTime;


    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
