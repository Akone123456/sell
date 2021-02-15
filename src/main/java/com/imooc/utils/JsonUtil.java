package com.imooc.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/*


2021-1-29 12:25
 */
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
