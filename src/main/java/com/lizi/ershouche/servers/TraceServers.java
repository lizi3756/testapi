package com.lizi.ershouche.servers;

import com.lizi.utils.MyHttpClient;
import com.lizi.utils.PropertyUtil;

import java.util.HashMap;
import java.util.Map;

//车商跟进，参数为表单格式
public class TraceServers {
    static String filePath="src/main/resources/ershoucheparams/trace.properties";
    static String serverUrl="/cardealer/trace/save";
    //static String cookies="id58=e87rZl4Wz5AcZ4WVBi3WAg==; wmda_uuid=09a75025a1c3506485e7ac499c80b126; wmda_new_uuid=1; 58tj_uuid=967b1bac-5bca-4e30-a0fc-62903d15b759; gr_user_id=a9df0bcb-4163-44de-8939-270fd262beb9; als=0; _bu=201805301036147d753980; bj58bsp_logininfo=userid%3D201805301036147d753980%26username%3Dzhangjingli%26realname%3D%E5%BC%A0%E6%95%AC%E4%B8%BD%26orgid%3D2017080711103314a25525%26dutyid%3D201101101655507f728cae%26eamil%3D18888812313%26dutyid%3D201101101655507f728cae%26siteTime%3D7F8B723866DB76D419FE867378E91719274E5B9597921FFC4%26sitekey%3D0C11B0481ECB0B374178D198F5D6ECF6D8EA2C547972EF6EE71BBD8668EB100B8; bj58bsp_login_token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2ppbmdsaSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTU5NzkwNjY0OSwiaWF0IjoxNTk3ODIwMjQ5LCJqdGkiOiIyMDE4MDUzMDEwMzYxNDdkNzUzOTgwIn0.F04Ak7Z8_2m69KiXAikrXtpb2YNAygthfRYSwiOduIQ; JSESSIONID=721D5BE2E36EE846B2D37EE401EA3D30; bj58bsp_login_token_shccrm=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2ppbmdsaSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTU5Nzg2NDE5Niwic3lzIjoic2hjY3JtIiwiaWF0IjoxNTk3ODIwOTk2LCJ1c2VySWQiOiIyMDE4MDUzMDEwMzYxNDdkNzUzOTgwIiwianRpIjoiMjAyMDA4MTkxNTA5NTY3MTI3MmU5YSIsIm9yZ0lkIjoiMjAxNzA4MDcxMTEwMzMxNGEyNTUyNSIsImVtYWlsIjoiMTg4ODg4MTIzMTMiLCJyZWFsbmFtZSI6IuW8oOaVrOS4vSJ9.ordAPFkCmUAv02oS3Tv4Na-uTIGnz9_oKnXEzmE_FOA";
    static String cookies = "_bu=201805301036147d753980; xinan_auth_agent_bspId=201805301036147d753980; bj58bsp_logininfo=userid%3D201805301036147d753980%26username%3Dzhangjingli%26realname%3D%E5%BC%A0%E6%95%AC%E4%B8%BD%26orgid%3D2017080711103314a25525%26dutyid%3D201101101655507f728cae%26eamil%3D18888812313%26dutyid%3D201101101655507f728cae%26siteTime%3D8CC2B010EB2FB467926B69483A3EC29F2CA346925E603F316%26sitekey%3D61D7D2CF189C8B54BE929A8D2E07EAD1DE2EE31C7936742013048EC40908DA796%26version%3Dv2; id58=e87rZGA9ncWIn7oSQLteAg==; JSESSIONID=21A8D5B9A37AD4ED54DA3D90832ED23A; bj58bsp_login_token_shccrm=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2ppbmdsaSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTYxNDg4NDY5Niwic3lzIjoic2hjY3JtIiwiaWF0IjoxNjE0ODQxNDk2LCJ1c2VySWQiOiIyMDE4MDUzMDEwMzYxNDdkNzUzOTgwIiwianRpIjoiMjAyMTAzMDQxNTA0NTY3OWU4NmE2YyIsIm9yZ0lkIjoiMjAxNzA4MDcxMTEwMzMxNGEyNTUyNSIsImVtYWlsIjoiMTg4ODg4MTIzMTMiLCJyZWFsbmFtZSI6IuW8oOaVrOS4vSJ9.6vrf1V-x_GubIgFfiddCVJGfxvkGH9-1KN3Q2uAQ47M";

    //登录正常流程
    public static String trace(String url) throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("X-Requested-With","XMLHttpRequest");
        headers.put("Cookie",cookies);
        String res = MyHttpClient.sendPost(url+serverUrl, headers, getParams());
        return res;
    }
    //登录异常流程用例，需要修改参数的值
    public static String trace(String url,String key,String value) throws Exception {
        Map<String,String> headers =new HashMap<String,String>();
        headers.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("X-Requested-With","XMLHttpRequest");
        headers.put("Cookie",cookies);
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
