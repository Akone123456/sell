package com.imooc.form;


import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class ProductForm {

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
    商品编号
     */

    private Integer categoryType;


}
