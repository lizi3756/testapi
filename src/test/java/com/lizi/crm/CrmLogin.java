package com.lizi.crm;

import com.alibaba.fastjson.JSONObject;
import com.lizi.utils.HttpUtil;
import com.lizi.utils.MyHttpClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CrmLogin {
    String token;
    @Test(description = "crm系统登录")
    public void test001_login() throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        Map<String,String> params =new HashMap<String,String>();
        params.put("username","admin");
        params.put("password","123456");
        String res = MyHttpClient.sendPost("http://192.168.1.4:8090/login", headers, params);
        Assert.assertTrue(res.contains("\"code\":0"));
        JSONObject jsonObject=JSONObject.parseObject(res);
        //token = jsonObject.get("Admin-Token").toString();
        token=jsonObject.getString("Admin-Token");
    }

    @Test(description = "增加客户，参数直接写在方法里")
    public void test002_addCustomer() throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Admin-Token",token);
        headers.put("Content-Type","application/json");
        String params="{\n" +
                "\t\"entity\": {\n" +
                "\t\t\"customer_name\": \"栗子123\",\n" +
                "\t\t\"mobile\": \"18991112345\",\n" +
                "\t\t\"telephone\": \"01028375678\",\n" +
                "\t\t\"website\": \"http://testfan.cn\",\n" +
                "\t\t\"next_time\": \"2020-04-02 00:00:00\",\n" +
                "\t\t\"remark\": \"这是备注\",\n" +
                "\t\t\"address\": \"北京市,北京城区,昌平区\",\n" +
                "\t\t\"detailAddress\": \"回龙观地铁\",\n" +
                "\t\t\"location\": \"\",\n" +
                "\t\t\"lng\": \"\",\n" +
                "\t\t\"lat\": \"\"\n" +
                "\t}\n" +
                "}";

        String res = MyHttpClient.sendPostJsonOrXml("http://192.168.1.4:8090/CrmCustomer/addOrUpdate", headers, params);
        Assert.assertTrue(res.contains("\"code\":0"));
        //{"code":0,"data":{"customerName":"栗子123","customerId":3}}
        JSONObject jsonObject =JSONObject.parseObject(res);
        JSONObject data = jsonObject.getJSONObject("data");
        String expcustomerName = data.getString("customerName");
        Assert.assertEquals(expcustomerName,"栗子123");
    }

    @Test(description = "增加客户，参数写在配置文件里")
    public void test003_addCustomer() throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Admin-Token",token);
        headers.put("Content-Type","application/json");
        String filePath="src/main/resources/crmparams/addCustomer.json";
        //将文件内容返回String格式
        String params = HttpUtil.getStringFromFile(filePath);
        String res = MyHttpClient.sendPostJsonOrXml("http://192.168.1.4:8090/CrmCustomer/addOrUpdate", headers, params);
        Assert.assertTrue(res.contains("\"code\":0"));
        //{"code":0,"data":{"customerName":"栗子123","customerId":3}}
        JSONObject jsonObject =JSONObject.parseObject(res);
        JSONObject data = jsonObject.getJSONObject("data");
        String expcustomerName = data.getString("customerName");
        Assert.assertEquals(expcustomerName,"栗子123");
    }
    @Test(description = "增加客户，参数写在配置文件里，手机号码格式不正确")
    public void test004_addCustomer() throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Admin-Token",token);
        headers.put("Content-Type","application/json");
        String filePath="src/main/resources/crmparams/addCustomer.json";
        //将文件内容返回String格式
        String params = HttpUtil.getStringFromFile(filePath);
        //读取配置文件中的json参数，并修改手机号为不正确的
        JSONObject paramsjsonObject =JSONObject.parseObject(params);
        JSONObject entity = paramsjsonObject.getJSONObject("entity");
        entity.put("mobile","aaaaaaaaaaa");
        paramsjsonObject.put("entity",entity);
        params = paramsjsonObject.toJSONString();

        String res = MyHttpClient.sendPostJsonOrXml("http://192.168.1.4:8090/CrmCustomer/addOrUpdate", headers, params);
        Assert.assertTrue(res.contains("\"code\":0"));
        //{"code":0,"data":{"customerName":"栗子123","customerId":3}}
        JSONObject jsonObject =JSONObject.parseObject(res);
        JSONObject data = jsonObject.getJSONObject("data");
        String expcustomerName = data.getString("customerName");
        Assert.assertEquals(expcustomerName,"栗子123");

    }


}
