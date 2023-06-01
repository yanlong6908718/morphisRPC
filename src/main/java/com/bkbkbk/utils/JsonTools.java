package com.bkbkbk.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonTools {
    /**/
    public static JSONObject getJson(String data){
        /*String返回json*/
        JSONObject json=JSONObject.parseObject(data);
//        System.out.println(json.size());
        return json;
    }
/*json转换成String*/
//    public static String getStr(String data){
//        String str=JSONObject.parseObject(data).toString();
//        return str;
//    }
/*
* 转换json获取key的值*/
    public static String getValueStr(String data ,String str){
        String valueStr=JSONObject.parseObject(data).get(str).toString();
        return valueStr;
    }
/*

* 转换json获取其中的json值*/
    public static JSONObject getValueJson(String data,String str){
        JSONObject json=JSONObject.parseObject(JSONObject.parseObject(data).get(str).toString());
        return json;
    }
}
