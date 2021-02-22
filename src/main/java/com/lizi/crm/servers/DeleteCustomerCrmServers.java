package com.lizi.crm.servers;

import com.lizi.utils.MyHttpClient;
import com.lizi.utils.PropertyUtil;

import java.util.HashMap;
import java.util.Map;

//登录的业务类，参数为表单格式
public class DeleteCustomerCrmServers {
    static String filePath="src/main/resources/crmparams/deleteCustomer.properties";
    static String serverUrl="/CrmCustomer/deleteByIds";

    //登录正常流程
    public static String deleteCustomer(String url,String token) throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Admin-Token",token);
        String res = MyHttpClient.sendPost(url+serverUrl, headers, getParams());
        return res;
    }
    //登录异常流程用例，需要修改参数的值
    public static String deleteCustomer(String url,String token,String key,String value) throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Admin-Token",token);
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
