package com.imooc.service;

/*

作者:刘新伟
时间:2021-1-20 23:57
 */


import com.imooc.dataobject.ProductCategory;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CategoryService {


    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory>  findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
