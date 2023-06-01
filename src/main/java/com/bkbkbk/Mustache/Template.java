package com.bkbkbk.Mustache;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mustachejava.DefaultMustacheFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

public class Template {

    /*
     * 配置参数模板
     * */
    static ObjectMapper MAPPER = new ObjectMapper();
    /*2019/07/01
     * data获取参数，读取文件返回字符串
     * */
    public static String templateString(String path, HashMap<String,Object> data)  {
        Writer writer=new StringWriter();
        new DefaultMustacheFactory().compile(path).execute(writer,data);
        return writer.toString();
    }
    /*2019/07/01
     * str获取参数，读取文件返回map对象
     * */
    public static HashMap templateStringSimply(String path, String str) throws IOException {
        Writer writer=new StringWriter();
        new DefaultMustacheFactory().compile(path).execute(writer,str);
        HashMap<String,Object> map= MAPPER.<HashMap>readValue(writer.toString(), HashMap.class);
        return map;
    }

    /*2019/07/01
     * data获取参数，读取文件返回map对象
     * */
    public static HashMap templatehashMap (String path,HashMap<String,Object> data) throws IOException {
        Writer writer=new StringWriter();
        new DefaultMustacheFactory().compile(path).execute(writer,data);
        HashMap<String,Object> map=MAPPER.readValue(writer.toString(),HashMap.class);
        return map;
    }

    public static HashMap template(String path)throws IOException{
        Writer writer=new StringWriter();
        String s = null;
        new DefaultMustacheFactory().compile(path).execute(writer,s);
        HashMap<String,Object> map=MAPPER.readValue(writer.toString(),HashMap.class);
        return map;
    }
}
