package com.lizi.crm.servers;

import com.alibaba.fastjson.JSONObject;
import com.lizi.utils.HttpUtil;
import com.lizi.utils.MyHttpClient;
import java.util.HashMap;
import java.util.Map;
/*参数：
* {
	"entity": {
		"customer_name": "客户123",
		"mobile": "18991112345",
		"telephone": "01028375678",
		"website": "http://testfan.cn",
		"next_time": "2020-04-02 00:00:00",
		"remark": "这是备注",
		"address": "北京市,北京城区,昌平区",
		"detailAddress": "霍营地铁",
		"location": "",
		"lng": "",
		"lat": ""
	}
}*/
//增加客户的的业务类
public class AddCustomerCrmServers {
    static String filePath="src/main/resources/crmparams/addCustomer.json";
    static String serverUrl="/CrmCustomer/addOrUpdate";

    //增加客户的正常流程
    public static String addCustomer(String url,String token) throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Admin-Token",token);
        headers.put("Content-Type","application/json");
        String res = MyHttpClient.sendPostJsonOrXml(url+serverUrl, headers, getParams());
        return res;
    }
    //增加客户的异常流程用例，需要修改参数的值
    public static String addCustomer(String url,String token,String key,String value) throws Exception {
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
