package com.imooc.controller;


import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/*

支付
2021 -1 - 27 23:32
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;
    //发起支付
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl,
                       Map<String,Object> map){
        //1.查询订单
        OrderDTO  orderDTO= orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
        PayResponse payResponse = payService.create(orderDTO);

       // returnUrl = "http://sell.com/#/order/450444659982860991";
        map.put("payResponse", payResponse);
        //在此处解码
        map.put("returnUrl", URLDecoder.decode(returnUrl));

        return new ModelAndView("pay/create", map);
    }

    //授权和支付联调的跳板
    @GetMapping("/proxy")
    public String proxy(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl){

        String baseUrl = "http://proxy.springboot.cn/pay?openid=oTgZpwbdFU8EfYDJiUEL6dEaMEKg";

        //记得先进行编码
        String new_url = baseUrl+"&"+"orderId="+orderId+"&returnUrl="+ URLEncoder.encode(returnUrl);

        return "redirect:"+new_url;
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        //返回给微信处理结果
        return new ModelAndView("pay/success");

    }
}
