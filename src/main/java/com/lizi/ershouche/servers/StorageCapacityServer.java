package com.lizi.ershouche.servers;

import com.lizi.utils.MyHttpClient;
import com.lizi.utils.PropertyUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lizi
 * @Date: 2020/12/3 7:25 下午
 */
public class StorageCapacityServer {
    //放置一组正确的测试用例数据
    static String filePath="src/main/resources/ershoucheparams/storagecapacity.properties";
    //测试接口的后面的uri
    static String serverUrl="/cardealer/storage-capacity/save-buyer";
    //接口的cookies信息
    static String cookies = "_bu=201805301036147d753980; xinan_auth_agent_bspId=201805301036147d753980; bj58bsp_logininfo=userid%3D201805301036147d753980%26username%3Dzhangjingli%26realname%3D%E5%BC%A0%E6%95%AC%E4%B8%BD%26orgid%3D2017080711103314a25525%26dutyid%3D201101101655507f728cae%26eamil%3D18888812313%26dutyid%3D201101101655507f728cae%26siteTime%3D8CC2B010EB2FB467926B69483A3EC29F2CA346925E603F316%26sitekey%3D61D7D2CF189C8B54BE929A8D2E07EAD1DE2EE31C7936742013048EC40908DA796%26version%3Dv2; id58=e87rZGA9ncWIn7oSQLteAg==; JSESSIONID=21A8D5B9A37AD4ED54DA3D90832ED23A; bj58bsp_login_token_shccrm=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2ppbmdsaSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTYxNDg4NDY5Niwic3lzIjoic2hjY3JtIiwiaWF0IjoxNjE0ODQxNDk2LCJ1c2VySWQiOiIyMDE4MDUzMDEwMzYxNDdkNzUzOTgwIiwianRpIjoiMjAyMTAzMDQxNTA0NTY3OWU4NmE2YyIsIm9yZ0lkIjoiMjAxNzA4MDcxMTEwMzMxNGEyNTUyNSIsImVtYWlsIjoiMTg4ODg4MTIzMTMiLCJyZWFsbmFtZSI6IuW8oOaVrOS4vSJ9.6vrf1V-x_GubIgFfiddCVJGfxvkGH9-1KN3Q2uAQ47M";
    //static String cookies ="JSESSIONID=D598362194141AFF60DA8F0F37886528; bj58bsp_login_token_shccrm=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2ppbmdsaSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTYxNDY5NDA0Miwic3lzIjoic2hjY3JtIiwiaWF0IjoxNjE0NjUwODQyLCJ1c2VySWQiOiIyMDE4MDUzMDEwMzYxNDdkNzUzOTgwIiwianRpIjoiMjAyMTAzMDIxMDA3MjI0MjA0Y2I0MiIsIm9yZ0lkIjoiMjAxNzA4MDcxMTEwMzMxNGEyNTUyNSIsImVtYWlsIjoiMTg4ODg4MTIzMTMiLCJyZWFsbmFtZSI6IuW8oOaVrOS4vSJ9.ywtDSlj1iJpBrU39Gtt0OkvCHmOUk_z03uI5pNLPRl8";

    public static String save(String url) throws Exception {
        Map<String ,String> header =new HashMap<>();
        header.put("Accept","application/json, text/plain, */*");
        header.put("Content-Type", "application/x-www-form-urlencoded");
        header.put("Cookie",cookies);
        String s = MyHttpClient.sendPost(url + serverUrl, header, getparams());
        return s;
    }
    public static  String save(String url,String key,String value) throws Exception {
        Map<String ,String> header =new HashMap<>();
        header.put("Accept","application/json, text/plain, */*");
        header.put("Content-Type", "application/x-www-form-urlencoded");
        header.put("Cookie",cookies);
        String s = MyHttpClient.sendPost(url + serverUrl, header, getparams(key, value));
        return s;

    }

    public static Map<String ,String> getparams(){
        Map<String ,String> param= PropertyUtil.getAllKeyValue(filePath);

        return param;

    }
    public static Map<String ,String> getparams(String key,String value){
        Map<String ,String> param= PropertyUtil.getAllKeyValue(filePath);
        param.replace(key, value);
        return param;

    }

}
