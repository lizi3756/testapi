package com.lizi.crm.testcases;

import com.alibaba.fastjson.JSONObject;
import com.lizi.crm.servers.AddCustomerCrmServers;
import com.lizi.crm.servers.LoginCrmServers;
import com.lizi.utils.JSONPathUtil;
import com.lizi.utils.JdbcDataUtil;
import com.lizi.utils.PropertyUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class CrmAddCustomerTest {
    static String url;
    static Connection conn;
    static String token;
    @BeforeClass
    public void init() throws Exception {
        Properties properties = PropertyUtil.getProperties("src/main/resources/httpuri.properties");
        url=properties.getProperty("http.crm.url");//从配置文件中读取url
        Properties dbproperties = PropertyUtil.getProperties("src/main/resources/db.properties");
        String dburl=dbproperties.getProperty("crm.jdbc.url");
        String dbusername=dbproperties.getProperty("crm.jdbc.username");
        String dbpwd=dbproperties.getProperty("crm.jdbc.password");
        conn= JdbcDataUtil.getConn(dburl,dbusername,dbpwd);
        /*String res = LoginCrmServers.login(url);
        token= JSONObject.parseObject(res).get("Admin-Token").toString();
        System.out.println("token:"+token);*/

    }
    @Test(description = "添加客户正常流程")
    public static void test001_add() throws Exception {
        String loginRes = LoginCrmServers.login(url);
        token = JSONPathUtil.extract(loginRes, "$.Admin-Token").toString();
        JdbcDataUtil.executeUpdate(conn,"DELETE FROM 72crm_crm_customer where customer_name='栗子123';");
        String res = AddCustomerCrmServers.addCustomer(url,token);
        Assert.assertTrue(res.contains("\"code\":0"));
        JSONObject jsonObject =JSONObject.parseObject(res);
        JSONObject data = jsonObject.getJSONObject("data");
        String expcustomerName = data.getString("customerName");//响应结果里面的内容
        Assert.assertEquals(expcustomerName,"栗子123");

        Object[][] dbdata = JdbcDataUtil.getData(conn, "SELECT customer_name FROM 72crm_crm_customer ORDER BY customer_id desc LIMIT 1;");
        //得到的结果是一个二维数组
        Assert.assertEquals(dbdata[0][0].toString(),expcustomerName);
    }
    @Test(description = "手机号码不足11位")
    public static void test002_add() throws Exception {
        String res = AddCustomerCrmServers.addCustomer(url,token,"mobile","1336615389");
        Assert.assertTrue(res.contains("手机号码格式不正确"));
    }

    @Test(description = "客户姓名为空")
    public static void test003_add() throws Exception {
        String res = AddCustomerCrmServers.addCustomer(url,token,"customer_name","");
        Assert.assertTrue(res.contains("客户姓名不能为空"));
    }
    @AfterClass
    public void close() throws SQLException {
        JdbcDataUtil.closeConn(conn);
    }
}
