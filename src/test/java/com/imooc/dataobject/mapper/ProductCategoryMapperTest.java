package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableServer.POA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private  ProductCategoryMapper productCategoryMapper;

    @Test
    public void insertByMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("categoryName","刘新伟最爱的");
        map.put("categorytype",123);

        int result = productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByMapObject() {
        ProductCategory productCategory = new ProductCategory();

        productCategory.setCategoryName("郁方正最爱的");
        productCategory.setCategoryType(100);

        int result =productCategoryMapper.insertByMapObject(productCategory);
        Assert.assertEquals(1,result);




    }

    @Test
    public void findByCategoryType() {

        ProductCategory productCategory =productCategoryMapper.findByCategoryType(100);

        Assert.assertNotNull(productCategory);

    }

    @Test
    public void findByCategoryName() {

        List<ProductCategory> list = productCategoryMapper.findByCategoryName("刘新伟最爱的");
        Assert.assertEquals(1,list.size());
    }

    @Test
    public void updateByCategoryType() {
        int result = productCategoryMapper.updateByCategoryType("刘新伟天下第一",100);

        Assert.assertEquals(1,result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();

        productCategory.setCategoryName("郁方正最爱的");
        productCategory.setCategoryType(100);


        int result= productCategoryMapper.updateByObject(productCategory);

        Assert.assertEquals(1,result);

    }

    @Test
    public void deleteByCategoryType() {

        int result = productCategoryMapper.deleteByCategoryType(100);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectBycategoryType() {

        ProductCategory productCategory = productCategoryMapper.selectBycategoryType(123);
        Assert.assertNotNull(productCategory);
    }
}