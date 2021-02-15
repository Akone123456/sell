package com.imooc.controller;

/*
卖家端类目 /列表/新增/修改
2021-2-8
 */

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.exception.SellException;
import com.imooc.form.CategoryForm;
import com.imooc.service.CategoryService;
import com.imooc.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellCategoryController {

    @Autowired
    private CategoryService categoryService;

    /*
    类目列表
    @param map
    @return
     */


    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){

        List<ProductCategory>  categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);

        return new ModelAndView("category/list",map);
    }


    /*
    展示
    @param categoryId  非必传，因为修改的时候需要ID，新增的时候不需要ID
    @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String,Object> map){
        if(categoryId!=null){
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("category",productCategory);
        }

        return  new ModelAndView("category/index",map);
    }


    /*
    修改类目信息
    @param form
    @param bindingResult
    @param map
    @return

     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){

        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }

        ProductCategory productCategory = new ProductCategory();


        //categoryId 自增所以不需要给他赋值

        try {
            //如果已经存在，说明这是修改操作，否则就是新增操作
            if(form.getCategoryId() != null){
                productCategory = categoryService.findOne(form.getCategoryId());
            }


            BeanUtils.copyProperties(form,productCategory);
            categoryService.save(productCategory);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/category/list");
        return new ModelAndView("common/success",map);
    }
}
