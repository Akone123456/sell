package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/*
2021-2-14 23:29
mybatis注解的使用
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name,category_type) values(#{categoryName,jdbcType=VARCHAR},#{categorytype,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);



    @Insert("insert into product_category(category_name,category_type) values(#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMapObject(ProductCategory productCategory);


    @Select("select * from product_category where category_type= #{categoryType}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType")
    })
    ProductCategory findByCategoryType(Integer categoryType);


    @Select("select * from product_category where category_name= #{categoryName}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name = #{categoryName} where category_type=#{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);


    @Update("update product_category set category_name = #{categoryName} where category_type=#{categoryType}")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where  category_type=#{categoryType}")
    int deleteByCategoryType(Integer categoryType);


    ProductCategory selectBycategoryType(Integer categoryType);
}
