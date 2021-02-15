package com.imooc.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
设置cookie
2021-2-13 20:19
 */
public class CookieUtil {

    public static  void set(HttpServletResponse response,
                            String name,
                            String value,
                            int maxAge){

        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /*
    获取cookie
    @param request
    @param name
    @return
     */
    public static  Cookie get(HttpServletRequest request,
                              String name){
     Map<String,Cookie> cookieMap = readCookie(request);
     if(cookieMap.containsKey(name)){
         return cookieMap.get(name);
     }
     else{
         return null;
     }

    }

    /*
    将cookie封转成Map
     */
    private  static  Map<String,Cookie> readCookie(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<>();

        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            for(Cookie cookie :cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;


    }
}
