package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(3);
        Assert.assertEquals(new Integer(2),productCategory.getCategoryType());
    }

    @Test
    public void findAll() {

        List<ProductCategory> result = categoryService.findAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> result = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    @Transactional
    public void save() {
        ProductCategory productCategory = categoryService.save(new ProductCategory("男生热爱",100));
        Assert.assertNotNull(productCategory);
    }
}