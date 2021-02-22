package com.lizi.ershouche;

import com.lizi.utils.JdbcDataUtil;
import com.lizi.utils.PropertyUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: lizi
 * @Date: 2020/10/19 5:57 下午
 */
public class TraceBase {
    public static String url;
    @BeforeClass
    public void init(){
        Properties properties =PropertyUtil.getProperties("src/main/resources/httpuri.properties");
        url=properties.getProperty("http.url");//从配置文件中读取url

    }
    @AfterClass
    public void close() throws SQLException {
        //JdbcDataUtil.closeConn(conn);
    }
}
