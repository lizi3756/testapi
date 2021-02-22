package com.lizi.utils;
/*
 * @author lizi

 * @date  2020/7/9 18:59
 */


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class MyHttpClient {
    private static Logger log = Logger.getLogger(MyHttpClient.class);
    private static final String HTTP ="http";
    private static final String HTTPS ="https";
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static SSLContextBuilder builder = null;
    private static HttpClient client;
    private static HttpPost httpPost;
    private static HttpGet httpGet;
    private static HttpResponse response;
    private static CookieStore cookieStore;

    static {
        try {
            cookieStore=new BasicCookieStore();
            builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(),
                    new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory()).register(HTTPS, sslsf).build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);// max connection
            client = HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(cm)
                    .setConnectionManagerShared(true).setDefaultCookieStore(cookieStore).build();
//
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //发送get请求
    public static String sendGet(String url, Map<String,String> headers, Map<String,String> params) throws Exception {

        String queryParam = HttpUtil.getQueryParam(params);
        log.info("queryParam:"+queryParam);
        Reporter.log("queryParam:"+queryParam);
        log.info("url:"+url+queryParam);
        Reporter.log("url:"+url+queryParam);
        httpGet=new HttpGet(url+queryParam);

        if(!headers.isEmpty()){
            for(Map.Entry<String,String> entry : headers.entrySet()){
                log.info("headers:"+entry.getKey()+":"+entry.getValue());
                Reporter.log("headers:"+entry.getKey()+":"+entry.getValue());
                httpPost.addHeader(entry.getKey(),entry.getValue());
            }
        }
        response=client.execute(httpGet);
        String res = EntityUtils.toString(response.getEntity());
        log.info("response:"+res);
        Reporter.log("response:"+res);
        return res;

    }
    //发送表单式的post请求
    public static String sendPost(String url, Map<String,String> headers, Map<String,String> params) throws Exception {
        log.info("url:"+url);
        Reporter.log("url:"+url);
        httpPost=new HttpPost(url);

        if(!headers.isEmpty()){
            for(Map.Entry<String,String> entry : headers.entrySet()){
                log.info("headers:"+entry.getKey()+":"+entry.getValue());
                Reporter.log("headers:"+entry.getKey()+":"+entry.getValue());
                httpPost.addHeader(entry.getKey(),entry.getValue());
            }
        }

        UrlEncodedFormEntity formEntity=HttpUtil.getFormEntiry(params);
        log.info("params:"+EntityUtils.toString(formEntity));
        Reporter.log("params:"+EntityUtils.toString(formEntity));

        httpPost.setEntity(formEntity);
        response= client.execute(httpPost);
        String res = EntityUtils.toString(response.getEntity());
        log.info("response:"+res);
        Reporter.log("response:"+res);
        return res;
    }
    //发送JsonOrXml的post请求
    public static String sendPostJsonOrXml(String url,Map<String,String> headers,String param) throws Exception {
        httpPost=new HttpPost(url);
        log.info("url:"+url);
        Reporter.log("url:"+url);

        log.info("params:"+param);
        Reporter.log("params:"+param);
        if(!headers.isEmpty()){
            for(Map.Entry<String,String> entry : headers.entrySet()){
                log.info("headers"+entry.getKey()+":"+entry.getValue());
                Reporter.log("headers:"+entry.getKey()+":"+entry.getValue());
                httpPost.addHeader(entry.getKey(),entry.getValue());
            }
        }

        HttpEntity entity =new StringEntity(param,"utf-8");
        httpPost.setEntity(entity);
        response=client.execute(httpPost);
        String res = EntityUtils.toString(response.getEntity());
        log.info("response:"+res);
        Reporter.log("response:"+res);
        return res;
    }
    //参数为json格式的请求
    public static String sendPostJson(String url, Map<String,String> headers, JSONObject jsonObject) throws IOException {
        log.info("url:"+url);
        Reporter.log("url:"+url);
        httpPost=new HttpPost(url);

        if(!headers.isEmpty()){
            for(Map.Entry<String,String> entry : headers.entrySet()){
                log.info("headers:"+entry.getKey()+":"+entry.getValue());
                Reporter.log("headers:"+entry.getKey()+":"+entry.getValue());
                httpPost.addHeader(entry.getKey(),entry.getValue());
            }
        }
        HttpEntity entity=new StringEntity(jsonObject.toJSONString(),"UTF-8");
        httpPost.setEntity(entity);
        response=client.execute(httpPost);
        String res = EntityUtils.toString(response.getEntity());
        log.info("response:"+res);
        Reporter.log("response:"+res);

        return res;
    }
    //上传文件的请求
    public static String sendUpload(String url, Map<String,String> headers,String filepath) throws Exception {
        log.info("url:"+url);
        Reporter.log("url:"+url);
        httpPost=new HttpPost(url);
        if(!headers.isEmpty()){
            for(Map.Entry<String,String> entry : headers.entrySet()){
                log.info("headers:"+entry.getKey()+":"+entry.getValue());
                Reporter.log("headers:"+entry.getKey()+":"+entry.getValue());
                httpPost.addHeader(entry.getKey(),entry.getValue());
            }
        }
        FileBody fileBody=new FileBody(new File(filepath));
        MultipartEntityBuilder builder =MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        HttpEntity fileEntity =builder.addPart("file",fileBody).build();
        httpPost.setEntity(fileEntity);
        response=client.execute(httpPost);
        String res = EntityUtils.toString(response.getEntity());
        return res;
    }
}
