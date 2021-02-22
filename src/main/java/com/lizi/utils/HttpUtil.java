package com.lizi.utils;
/*
 * @author lizi

 * @date  2020/7/9 19:23
 */

import org.apache.commons.io.FileUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Reporter;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {
    static HttpPost httpPost;
    //拼接get请求后面的参数列表，返回string
    public static String getQueryParam(Map<String, String> queryMap) throws Exception {
        StringBuilder accum = new StringBuilder();

        for(Map.Entry<String, String> entry:queryMap.entrySet()){
            accum.append("&").append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(),"utf-8"));
        }
        String queryParam = accum.toString().replaceFirst("&", "?");
        return queryParam;
    }


    public static UrlEncodedFormEntity getFormEntiry(Map<String,String> map) throws Exception {
        List<NameValuePair> paramList =new ArrayList<NameValuePair>();
        for(Map.Entry<String,String> entry : map.entrySet()){
            paramList.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(paramList, Charset.forName("utf-8"));
        return  entity;
    }
    //将文件转换成StringEntity格式
    public static StringEntity getDataFromFile(String filepath) throws Exception {
        File dataFile =new File(filepath);
        String data = FileUtils.readFileToString(dataFile);
        StringEntity stringEntity=new StringEntity(data,"utf-8");
        return stringEntity;
    }
    //将文件内容返回String格式
    public static String getStringFromFile(String filepath) throws Exception {
        File dataFile =new File(filepath);
        String data = FileUtils.readFileToString(dataFile);
        return  data;
    }




}
