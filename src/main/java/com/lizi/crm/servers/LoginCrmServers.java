package com.lizi.crm.servers;

import com.lizi.utils.MyHttpClient;
import com.lizi.utils.PropertyUtil;

import java.util.HashMap;
import java.util.Map;
//登录的业务类，参数为表单格式
public class LoginCrmServers {
    static String filePath="src/main/resources/crmparams/login.properties";
    static String serverUrl="/login";

    //登录正常流程
    public static String login(String url) throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        String res = MyHttpClient.sendPost(url+serverUrl, headers, getParams());
        return res;
    }
    //登录异常流程用例，需要修改参数的值
    public static String login(String url,String key,String value) throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        String res = MyHttpClient.sendPost(url+serverUrl, headers, getParams(key,value));
        return res;
    }

    public static Map<String, String> getParams(){
        Map<String,String> params =new HashMap<String,String>();
        params = PropertyUtil.getAllKeyValue(filePath);
        return params;
    }
    public static Map<String, String> getParams(String key,String value){
        Map<String,String> params =new HashMap<String,String>();
        params = PropertyUtil.getAllKeyValue(filePath);
        params.replace(key,value);
        return params;
    }





}
