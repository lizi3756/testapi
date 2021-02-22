package com.lizi.crm.servers;

import com.alibaba.fastjson.JSONObject;
import com.lizi.utils.HttpUtil;
import com.lizi.utils.MyHttpClient;

import java.util.HashMap;
import java.util.Map;

/*参数：
*
*/
//增加联系人的的业务类
public class AddContactCrmServers {
    static String filePath="src/main/resources/crmparams/addContact.json";
    static String serverUrl="/CrmContacts/addOrUpdate";

    //增加联系人的正常流程
    public static String addContact(String url,String token) throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Admin-Token",token);
        headers.put("Content-Type","application/json");
        String res = MyHttpClient.sendPostJsonOrXml(url+serverUrl, headers, getParams());
        return res;
    }
    //增加联系人的异常流程用例，需要修改参数的值
    public static String addContact(String url,String token,String key,String value) throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Admin-Token",token);
        headers.put("Content-Type","application/json");
        String res = MyHttpClient.sendPostJsonOrXml(url+serverUrl, headers, getParams(key,value));
        return res;
    }

    public static String getParams() throws Exception {
        //将文件中的参数改成字符串
        String params = HttpUtil.getStringFromFile(filePath);
        return params;
    }
    public static String getParams(String key,String value) throws Exception {
        String params = HttpUtil.getStringFromFile(filePath);
        JSONObject jsonObject = JSONObject.parseObject(params);
        jsonObject.getJSONObject("entity").replace(key,value);
        params = jsonObject.toJSONString();
        return params;
    }





}
