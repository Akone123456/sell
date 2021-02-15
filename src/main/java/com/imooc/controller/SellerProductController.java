package com.imooc.controller;


/*

卖家商品列表
2021-2-1
 */

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.OrderDTO;
import com.imooc.exception.SellException;
import com.imooc.form.ProductForm;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /*
    商品列表
    @param page
    @param size
    @param map
    @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "3") Integer size,
                             Map<String,Object> map){

        PageRequest pageRequest = new PageRequest(page-1,size);

        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);

        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);
    }

    /*
    商品上架
    @param productId
    @param map
    @return
     */
    @GetMapping("/on_sale")
    public ModelAndView onsale(@RequestParam("productId") String productId,
                               Map<String,Object> map){
        try{
            productService.onSale(productId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }



    /*
    商品下架
    @param productId
    @param map
    @return
     */
    @GetMapping("/off_sale")
    public ModelAndView offsale(@RequestParam("productId") String productId,
                               Map<String,Object> map){
        try{
            productService.offSale(productId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    /*

    @param productId 可以需要也可以不需要 参数带require即可
    @return

     */

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId
                            ,Map<String,Object> map)  {
        //1.判断productId是否为空，因为这是不必要穿的参数。传与不传的效果是不一样的
        if(!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo",productInfo);
        }

        //查询所有的类目
        List<ProductCategory> categoryList = categoryService.findAll();

        map.put("categoryList",categoryList);

        return  new ModelAndView("product/index",map);


    }

    /*
    保存/更新
    @param form
    @param bindingResult
    @parm map
    @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }

        ProductInfo productInfo = new ProductInfo();


        //因为无法修改状态，必须先查询当前productInfo的信息，
        //然后再从表单复制过去，避免了productInfo状态为null
        try {
            if(!StringUtils.isEmpty(form.getProductId())){
                productInfo = productService.findOne(form.getProductId());
            }
            else{
                form.setProductId(KeyUtil.genUniqueKey());
            }

            BeanUtils.copyProperties(form,productInfo);
            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }

       map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);

    }
}
