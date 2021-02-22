package com.lizi.mtx.servers;
/*
 * @author lizi

 * @date  2020/7/16 17:39
 */

import com.lizi.utils.MyHttpClient;
import com.lizi.utils.PropertyUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginMtxServer {
    static String filepath="src/main/resources/mtxparams/login.properties";
    static String serverpath="/mtx/index.php?s=/index/user/login.html";

    public static String login(String url) throws Exception {
        Map<String,String> headers =new HashMap<String, String>();
        headers.put("X-Requested-With","XMLHttpRequest");
        String res = MyHttpClient.sendPost(url + serverpath, headers, getparams());

        return res;
    }
    public static String login(String url,String key,String value) throws Exception {
        Map<String,String> headers =new HashMap<String, String>();
        headers.put("X-Requested-With","XMLHttpRequest");
        String res = MyHttpClient.sendPost(url + serverpath, headers, getparams(key,value));
        return res;
    }

    public static Map<String, String> getparams(){
        Map<String,String> params =new HashMap<String, String>();
        params= PropertyUtil.getAllKeyValue(filepath);
        return params;

    }
    public static Map<String, String> getparams(String key,String value){
        Map<String,String> params =new HashMap<String, String>();
        params= PropertyUtil.getAllKeyValue(filepath);
        params.replace(key,value);
        return params;

    }
}
