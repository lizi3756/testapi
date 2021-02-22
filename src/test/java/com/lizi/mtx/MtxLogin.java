package com.lizi.mtx;

import com.lizi.utils.MyHttpClient;
import com.lizi.utils.PropertyUtil;
import com.sun.net.httpserver.Headers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class MtxLogin {

    @Test(description = "MTX商城登录")
    public void test001_loginmtx() throws Exception {
        Map<String,String> headers =new HashMap<String, String>();
        headers.put("X-Requested-With","XMLHttpRequest");
        Map<String,String> params =new HashMap<String, String>();
        String filePath="src/main/resources/mtxparams/login.properties";
        params= PropertyUtil.getAllKeyValue(filePath);
        String res = MyHttpClient.sendPost("http://192.168.1.4/mtx/index.php?s=/index/user/login.html", headers, params);
        Assert.assertTrue(res.contains("登录成功"));

    }

    @Test(description = "加入购物车")
    public static void test002_add() throws Exception {
        Map<String,String> headers =new HashMap<String, String>();
        headers.put("X-Requested-With","XMLHttpRequest");
        Map<String,String> params =new HashMap<String, String>();
        String filePath="src/main/resources/mtxparams/add.properties";
        params=PropertyUtil.getAllKeyValue(filePath);
        String res = MyHttpClient.sendPost("http://192.168.1.4/mtx/index.php?s=/index/cart/save.html", headers, params);
        Assert.assertTrue(res.contains("加入成功"));
    }
    @Test(description = "商品id不存在")
    public static void test003_add() throws Exception {
        Map<String,String> headers =new HashMap<String, String>();
        headers.put("X-Requested-With","XMLHttpRequest");
        Map<String,String> params =new HashMap<String, String>();
        String filePath="src/main/resources/mtxparams/add.properties";
        params=PropertyUtil.getAllKeyValue(filePath);
        params.put("goods_id","9999");
        String res = MyHttpClient.sendPost("http://192.168.1.4/mtx/index.php?s=/index/cart/save.html", headers, params);
        Assert.assertTrue(res.contains("商品不存在或已删除"));
    }

}

