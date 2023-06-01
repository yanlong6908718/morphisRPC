package com.bkbkbk.HttpServer;

import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpUtils {
    public static String Path="/";  //session路径
    /**
     * 发送Get请求,无参数
     * params url
     * return response
     */
    public static String http_GetWithUrl(String Apiurl){
        Response response=
                given()
                        .log().all()
                        .when()
                        .get(Apiurl)
                        .then()
                        .log().all()
                        .extract().response();
        return response.print();
    }

    /*
     * 发送Get请求，带参数
     * param Apiurl,map
     * return response
     * */
    public static String http_GetWithParams(String Apiurl,Map<String,Object> map){
        Response response=
                given()
                        .queryParams(map)
                        .log().all()
                        .when()
                        .get(Apiurl)
                        .then()
                        .log().all()
                        .extract().response();
        return response.print();
    }

    /**
     * post访问接口
     * params url,map
     * return respons
     */
    public static String http_PostWithParams(String Apiurl, Map<String,Object> map){
        Response response=
                given()
                        .contentType("application/json")
                        .body(map)
                        .log().all()
                        .when()
                        .post(Apiurl)
                        .then()
                        .log().all()
                        .extract().response();
        return response.print();
    }

    /**
     * post访问接口
     * params url,map
     * return respons
     */
    public static String http_PostWithParams(String Apiurl, String params ){
        Response response=
                given()
                        .contentType("application/json")
                        .body(params)
                        .log().all()
                        .when()
                        .post(Apiurl)
                        .then()
                        .log().all()
                        .extract().response();
        return response.print();
    }

    /**
     * post访问接口
     * params url,list
     * return respons
     */
    public static String http_PostWithParamsList(String Apiurl, List list){
        Response response=
                given()
                        .contentType("application/json")
                        .body(list)
                        .log().all()
                        .when()
                        .post(Apiurl)
                        .then()
                        .log().all()
                        .extract().response();
        return response.print();
    }

    /*multiPart发送邮件附件
     *contentType("multipart/form-data;charset=utf-8")
     * formParams(map)
     * */
    public static String http_PostWithParamsAndmultiPart(String Apiurl,String path,Map<String,Object> map){
        Response response=
                given()
                        .contentType("multipart/form-data;charset=utf-8")
                        .multiPart("attachment",new File(path))
                        .formParams(map)
                        .log().all()
                        .when()
                        .post(Apiurl)
                        .then()
                        .log().all()
                        .extract().response();
        return response.print();
    }

    /*
     * 登录之后发送Post请求
     * params url,sessin,map
     * return response
     * */
    public  static String http_PostWithSessionParams(String Apiurl,String Sessionid,Map<String,Object> map){
        Cookie cookie=new Cookie.Builder("SESSION",Sessionid).setPath(Path).setHttpOnly(true).setDomain("samuraidev.wxblockchain.com").build();
        Response response=
                given()
                        .cookie(cookie)
                        .contentType("application/json")
                        .body(map)
                        .log().all()
                        .when()
                        .post(Apiurl)
                        .then()
                        .log().all()
                        .extract().response();
        return response.print();
    }
    /*发送post请求，无参数
     * params
     * return response
     * */
    public  static String http_PostWithSession(String Apiurl,String Sessionid){
        Cookie cookie=new Cookie.Builder("SESSION",Sessionid).setPath(Path).setHttpOnly(true).build();
        Response response=
                given()
                        .header("X-Application-Context","rockyGateway:production:8001").header("Content-Encoding","gzip")
                        .cookie(cookie)
                        .contentType("application/json")
                        .log().all()
                        .when()
                        .post(Apiurl);
        return response.print();
    }


    /**
     * 登陆以后获取session
     * params url,map
     * return session
     */

    public static String http_GetSession(String Apiurl,Map<String,Object> map){
        Response response=
                given()
                        .contentType("application/json")
                        .body(map)
                        .log().all()
                        .when()
                        .post(Apiurl)
                        .then()
                        .log().body()
                        .extract().response();
        String sessionid=response.getCookies().get("SESSION");
        return sessionid;
    }

    public static String http_GetWithSession(String Apiurl,String session){
        Cookie cookie=new Cookie.Builder("SESSION",session).setPath(Path).setHttpOnly(true).build();
        Response response=
                given()
                        .log()
                        .all().cookie(cookie)
                        .when()
                        .get(Apiurl)
                        .then()
                        .log()
                        .all()
                        .extract().response();
        return  response.print();
    }

}
