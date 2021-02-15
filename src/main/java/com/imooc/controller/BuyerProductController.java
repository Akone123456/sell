package com.imooc.controller;


import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.impl.CategoryServiceImpl;
import com.imooc.service.impl.ProductServiceImpl;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*

买家商品
时间:2021-1-21 15:08
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private CategoryServiceImpl categoryService;


    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有的商家商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询上架类目(一次性查完)
        //精简方法lambda 得到所有上架商品的类目编号
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e->e.getCategoryType()).collect(Collectors.toList());
        //根据已上架的类目编号得到商品类目的详细信息
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装

        System.out.println(productInfoList.size()+"==========");
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory :productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO>  productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo :productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){

                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //快捷方法，将类与类相同的属性，拷贝粘贴一份
                    BeanUtils.copyProperties(productInfo,productInfoVO);

                    productInfoVOList.add(productInfoVO);

                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }
        return ResultVOUtil.success(productVOList);
    }
}
