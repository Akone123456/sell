package com.imooc.dataobject;

/*
类目
Created by 刘新伟
2021-1-20-15.08
 */

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    /*类目id  .*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /*
    类目名
     */
    private  String categoryName;

    /*
    创建一开始的时间
     */
    private Date createTime;


    /*
    更新的时间
     */
    private  Date updateTime;

    /*
 类目编号
  */
    private Integer categoryType;


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}











