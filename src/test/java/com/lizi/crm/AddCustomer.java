package com.lizi.crm;

import com.alibaba.fastjson.JSONObject;
import com.lizi.utils.HttpUtil;
import com.lizi.utils.JdbcDataUtil;
import com.lizi.utils.MyHttpClient;
import com.lizi.utils.PropertyUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AddCustomer {
    String token;
    String url;
    Connection conn;
    @BeforeClass
    public void init(){
        Properties properties = PropertyUtil.getProperties("src/main/resources/httpuri.properties");
        url=properties.getProperty("http.crm.url");//从配置文件中读取url
        Properties dbproperties = PropertyUtil.getProperties("src/main/resources/db.properties");
        String dburl=dbproperties.getProperty("crm.jdbc.url");
        String dbusername=dbproperties.getProperty("crm.jdbc.username");
        String dbpwd=dbproperties.getProperty("crm.jdbc.password");
        conn= JdbcDataUtil.getConn(dburl,dbusername,dbpwd);
        //执行前，先把数据库中的脏数据清理掉
        JdbcDataUtil.executeUpdate(conn,"DELETE FROM 72crm_crm_customer where customer_name='栗子123';");

    }
    @Test(description = "crm系统登录")
    public void test001_login() throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        Map<String,String> params =new HashMap<String,String>();
        params = PropertyUtil.getAllKeyValue("src/main/resources/crmparams/login.properties");
        String res = MyHttpClient.sendPost(url+"/login", headers, params);
        Assert.assertTrue(res.contains("\"code\":0"));
        JSONObject jsonObject=JSONObject.parseObject(res);
        token=jsonObject.getString("Admin-Token");
    }

    @Test(description = "增加客户，参数写在配置文件里")
    public void test002_addCustomer() throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Admin-Token",token);
        headers.put("Content-Type","application/json");
        //将文件内容返回String格式
        String params = HttpUtil.getStringFromFile("src/main/resources/crmparams/addCustomer.json");
        String res = MyHttpClient.sendPostJsonOrXml(url+"/CrmCustomer/addOrUpdate", headers, params);
        Assert.assertTrue(res.contains("\"code\":0"));
        JSONObject jsonObject =JSONObject.parseObject(res);
        JSONObject data = jsonObject.getJSONObject("data");
        String expcustomerName = data.getString("customerName");//响应结果里面的内容
        Assert.assertEquals(expcustomerName,"栗子123");

        Object[][] dbdata = JdbcDataUtil.getData(conn, "SELECT customer_name FROM 72crm_crm_customer ORDER BY customer_id desc LIMIT 1;");
        //得到的结果是一个二维数组
        Assert.assertEquals(dbdata[0][0].toString(),expcustomerName);
    }

    @AfterClass
    public void close() throws SQLException {
        JdbcDataUtil.closeConn(conn);
    }

}
