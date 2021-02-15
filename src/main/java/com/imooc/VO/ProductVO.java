package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/*
商品包含类目
2021-1-21 15:15
 */
@Data
public class ProductVO implements Serializable {


    private static final long serialVersionUID = 7097863777546530545L;


    @JsonProperty("name") //会将该categoryName转换成前端http请求所需要的状态
    private String categoryName;

    @JsonProperty("type")
    private  Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
