package com.lizi.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @Author: lizi
 * @Date: 2020/10/14 2:55 下午
 */
public class Test1 {
    private static HttpClient httpClient;
    private static HttpPost httpPost;
    private static HttpGet httpGet;


    public static Properties test(String file){
        Properties prop=new Properties();

        BufferedReader br=null;
        try {
            br= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            prop.load(br);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop;
    }

    public  static  String  get(String url,Map<String,String> header ,Map<String,String> params) throws Exception {

        httpGet.addHeader("","");
        String queryParam = getQueryParam(params);
        httpGet=new HttpGet(url+queryParam);
        HttpResponse response = httpClient.execute(httpGet);
        String s = EntityUtils.toString(response.getEntity());
        return s;

    }

    public static String get1(String url,Map<String,String> header ,Map<String,String> params) throws Exception{
        String queryParam = getQueryParam(params);
        httpGet =new HttpGet(url+queryParam);
        httpGet.addHeader("","");
        HttpResponse response = httpClient.execute(httpGet);
        String s = EntityUtils.toString(response.getEntity());
        return s;

    }
    public static String getQueryParam(Map<String,String> param){
        StringBuilder sb =new StringBuilder();
        for(Map.Entry<String,String> map: param.entrySet()){
            sb.append("&").append(map.getKey()).append("=").append(map.getValue());
        }
        String s = sb.toString().replaceFirst("&", "?");
        return s;
    }

    public static UrlEncodedFormEntity getFormEntiry(Map<String,String> param) throws Exception{
        List<NameValuePair> list=new ArrayList();
        for (Map.Entry<String,String> map :param.entrySet()){
            NameValuePair n=new BasicNameValuePair(map.getKey(),map.getValue());
            list.add(n);
        }
        UrlEncodedFormEntity urlEncodedFormEntity=new UrlEncodedFormEntity(list,Charset.forName("utf-8"));

        return urlEncodedFormEntity;


    }

    public  static  String  post(String url,Map<String,String> header ,Map<String,String> params) throws Exception {
        httpPost= new HttpPost(url);
        httpPost.addHeader("","");
        UrlEncodedFormEntity urlEncodedFormEntity =getFormEntiry(params);
        httpPost.setEntity(urlEncodedFormEntity);
        HttpResponse response = httpClient.execute(httpPost);
        String s = EntityUtils.toString(response.getEntity());
        return s;

    }

    public static String postforxml(String url,Map<String,String> header ,String params) throws IOException {
        httpPost =new HttpPost(url);
        httpPost.addHeader("", "");
        StringEntity stringEntity = new StringEntity(params,"utf-8");
        httpPost.setEntity(stringEntity);
        HttpResponse response = httpClient.execute(httpPost);
        String s = EntityUtils.toString(response.getEntity());
        return s;


    }

    public static String postforJson(String url, Map<String,String> header , JSONObject jsonObject) throws IOException {
        httpPost =new HttpPost(url);
        httpPost.addHeader("", "");
        String s = jsonObject.toJSONString();
        StringEntity entity =new StringEntity(s);
        httpPost.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        String s1 = EntityUtils.toString(httpResponse.getEntity());
        return s1;
    }

    public static String upload(String url, Map<String,String> header ,String filePath) throws IOException {
        httpPost =new HttpPost(url);
        httpPost.addHeader("", "");

        FileBody fileBody=new FileBody(new File(filePath));
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        HttpEntity entity = builder.addPart("file", fileBody).build();
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        String s = EntityUtils.toString(response.getEntity());
        return s;
    }

    public static String upload1(String url, Map<String,String> header ,String filePath) throws IOException {
        httpPost =new HttpPost(url);
        httpPost.addHeader("", "");
        FileBody fileBody=new FileBody(new File(filePath));
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        HttpEntity entity = builder.addPart("file", fileBody).build();
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        String s = EntityUtils.toString(response.getEntity());
        return s;

    }
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();  // 用/文件名， / 表示根目录
        InputStream input1=Test1.class.getClassLoader().getResourceAsStream("httpuri.properties");
        properties.load(input1);
        String value=properties.getProperty("http.mtxshop.url");
        System.out.println(value);
        /*Enumeration<String> names=(Enumeration<String>) properties.propertyNames();
        while(names.hasMoreElements()){
            //这是key值
            String key=names.nextElement();
            String value=properties.getProperty(key);
            System.out.println(key+"="+value);
        }*/

    }




    //CloseableHttpClient httpClient;
    /*@Test
    public void test_001_login() throws Exception {
        httpClient = HttpClients.createDefault();
        HttpPost post=new HttpPost("");
        post.setHeader("","");
        BasicNameValuePair username=new BasicNameValuePair("username","lizi");
        BasicNameValuePair pwd =new BasicNameValuePair("password","123456");
        List<BasicNameValuePair> params=new ArrayList<>();
        params.add(username);
        params.add(pwd);
        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params);//param1=value1&param2=value2
        post.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(post);
        String s = EntityUtils.toString(response.getEntity());



    }*/
}
