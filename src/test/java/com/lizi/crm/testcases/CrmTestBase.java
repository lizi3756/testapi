package com.lizi.crm.testcases;

import com.alibaba.fastjson.JSONObject;
import com.lizi.crm.servers.LoginCrmServers;
import com.lizi.utils.JdbcDataUtil;
import com.lizi.utils.PropertyUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class CrmTestBase {
    public static String url;
    public static Connection conn;
    public static String token;
    @BeforeClass
    public static void init() throws Exception {
        Properties properties = PropertyUtil.getProperties("src/main/resources/httpuri.properties");
        url=properties.getProperty("http.crm.url");//从配置文件中读取url
        Properties dbproperties = PropertyUtil.getProperties("src/main/resources/db.properties");
        String dburl=dbproperties.getProperty("crm.jdbc.url");
        String dbusername=dbproperties.getProperty("crm.jdbc.username");
        String dbpwd=dbproperties.getProperty("crm.jdbc.password");
        conn= JdbcDataUtil.getConn(dburl,dbusername,dbpwd);
        String res = LoginCrmServers.login(url);
        token= JSONObject.parseObject(res).get("Admin-Token").toString();
        System.out.println("token:"+token);

    }

    @AfterClass
    public void close() throws SQLException {
        JdbcDataUtil.closeConn(conn);
    }
}
