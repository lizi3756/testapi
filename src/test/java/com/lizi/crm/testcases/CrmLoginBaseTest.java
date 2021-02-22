package com.lizi.crm.testcases;

import com.lizi.crm.servers.LoginCrmServers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrmLoginBaseTest extends CrmTestBase{

    @DataProvider
    public static Object[][] getdata(){
        Object[][] obj ={
                {"username", "hahahha","用户名或密码错误"},
                {"password", "111111","用户名或密码错误"}
        };
        return obj;
    }


    @Test(dataProvider = "getdata",description = "数据驱动")
    public static void test0010_login(String key,String value,String assertValue) throws Exception {
        String res = LoginCrmServers.login(url, key, value);
        Assert.assertTrue(res.contains(assertValue));
    }

    //@Test(description = "登录成功")
    public static void test001_login() throws Exception {
        String res = LoginCrmServers.login(url);
        Assert.assertTrue(res.contains("\"code\":0"));
    }
    //@Test(description = "用户名不存在")
    public static void test002_login() throws Exception {
        String res = LoginCrmServers.login(url, "username", "hahahha");
        Assert.assertTrue(res.contains("用户名或密码错误"));
    }
    //@Test(description = "密码错误")
    public static void test003_login() throws Exception {
        String res = LoginCrmServers.login(url, "password", "111111");
        Assert.assertTrue(res.contains("用户名或密码错误"));
    }
}
