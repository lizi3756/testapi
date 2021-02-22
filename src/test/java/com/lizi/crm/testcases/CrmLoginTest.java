package com.lizi.crm.testcases;

import com.lizi.crm.servers.LoginCrmServers;
import com.lizi.utils.JdbcDataUtil;
import com.lizi.utils.PropertyUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
/*
* CRM系统的登录测试
* */
public class CrmLoginTest {
    static String url;
    static Connection conn;
    @BeforeClass
    public void init(){
        Properties properties = PropertyUtil.getProperties("src/main/resources/httpuri.properties");
        url=properties.getProperty("http.crm.url");//从配置文件中读取url
        Properties dbproperties = PropertyUtil.getProperties("src/main/resources/db.properties");
        String dburl=dbproperties.getProperty("crm.jdbc.url");
        String dbusername=dbproperties.getProperty("crm.jdbc.username");
        String dbpwd=dbproperties.getProperty("crm.jdbc.password");
        conn= JdbcDataUtil.getConn(dburl,dbusername,dbpwd);
    }
    @Test(description = "登录成功")
    public static void test001_login() throws Exception {
        String res = LoginCrmServers.login(url);
        Assert.assertTrue(res.contains("\"code\":0"));
    }
    @Test(description = "用户名不存在")
    public static void test002_login() throws Exception {
        String res = LoginCrmServers.login(url, "username", "hahahha");
        Assert.assertTrue(res.contains("用户名或密码错误"));
    }
    @Test(description = "密码错误")
    public static void test003_login() throws Exception {
        String res = LoginCrmServers.login(url, "password", "111111");
        Assert.assertTrue(res.contains("用户名或密码错误"));
    }
    @AfterClass
    public void close() throws SQLException {
        JdbcDataUtil.closeConn(conn);
    }
}
