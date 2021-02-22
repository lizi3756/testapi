package com;
/*
 * @author lizi

 * @date  2020/7/8 10:32
 */



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import org.apache.http.entity.mime.content.FileBody;


public class httpBasic {
    CloseableHttpClient httpClient;
    @Test(description = "mtx登录")
    public void test001_login() throws Exception {
        httpClient = HttpClients.createDefault();//创建一个http客户端
        HttpPost post =new HttpPost("http://10.252.52.188/mtx/index.php?s=/index/user/login.html");//post请求以及url
        post.setHeader("X-Requested-With","XMLHttpRequest");//设置请求头
        //传参数
       /* BasicNameValuePair username =new BasicNameValuePair("accounts","lizi");
        BasicNameValuePair pwd =new BasicNameValuePair("pwd","123456");
        List<NameValuePair> params =new ArrayList<NameValuePair>();//创建一个列表放置参数
        params.add(username);//把参数添加到list里面
        params.add(pwd);*/
        List<NameValuePair> params =new ArrayList<NameValuePair>();//创建一个列表放置参数
        params.add(new BasicNameValuePair("accounts","lizi"));
        params.add(new BasicNameValuePair("pwd","123456"));
        UrlEncodedFormEntity entity =new UrlEncodedFormEntity(params);
        post.setEntity(entity);//设置参数到post对象
        CloseableHttpResponse response = httpClient.execute(post);//发起post请求
        String reString = EntityUtils.toString(response.getEntity());//把返回结果转成字符串
        System.out.println(reString);
    }

    @Test(description = "加入购物车")
    public void test002_add() throws Exception {
        //CloseableHttpClient httpClient =HttpClients.createDefault();
        HttpPost post =new HttpPost("http://10.252.52.188/mtx/index.php?s=/index/cart/save.html");
        post.setHeader("X-Requested-With","XMLHttpRequest");
        BasicNameValuePair goods_id =new BasicNameValuePair("goods_id", "ershoucheparams");
        BasicNameValuePair stock =new BasicNameValuePair("stock", "ershoucheparams");
        List<NameValuePair> params =new ArrayList<NameValuePair>();
        params.add(goods_id);
        params.add(stock);
        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params);
        post.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(post);
        String reString = EntityUtils.toString(response.getEntity());
        System.out.println(reString);
    }

    @Test(description = "pinter的get接口")
    public void test003_getid() throws Exception {
        HttpGet get =new HttpGet("http://10.252.52.188:8080/pinter/com/getSku?id=1");
        CloseableHttpResponse response = httpClient.execute(get);//执行get请求
        String reString = EntityUtils.toString(response.getEntity());
        System.out.println(reString);
    }

    @Test(description = "json参数请求")
    public void  test004_json() throws Exception {
        HttpPost post=new HttpPost("http://10.252.52.188:8080/pinter/com/register");
        post.setHeader("Content-type","application/json");
        String json="{\"userName\":\"test\",\"password\":\"1234\",\"gender\":1,\"phoneNum\":\"110\",\"email\":\"beihe@163.com\",\"address\":\"Beijing\"} ";
        HttpEntity entity=new StringEntity(json);
        post.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(post);
        String reString = EntityUtils.toString(response.getEntity());
        System.out.println(reString);
    }

    @Test(description = "xml格式")
    public void test005_xml() throws Exception {
        HttpPost post =new HttpPost("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
        post.setHeader("Content-Type","text/xml; charset=utf-8");
        String xml ="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">\n" +
                "      <mobileCode>13366153891</mobileCode>\n" +
                "      <userID></userID>\n" +
                "    </getMobileCodeInfo>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
        HttpEntity xmlEntity=new StringEntity(xml);
        post.setEntity(xmlEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        String reString = EntityUtils.toString(response.getEntity());
        System.out.println(reString);
    }

    @Test(description = "upload")
    public void test006_upload() throws Exception {
        HttpPost post =new HttpPost("http://10.252.52.188:8080/pinter/file/api/upload2");
        FileBody fileBody=new FileBody(new File("C:\\Users\\lixio\\Desktop\\222.txt"));
        MultipartEntityBuilder builder =MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        HttpEntity fileEntity =builder.addPart("file",fileBody).build();
        post.setEntity(fileEntity);
        CloseableHttpResponse reponse = httpClient.execute(post);
        String reString = EntityUtils.toString(reponse.getEntity());
        System.out.println(reString);

    }
}
