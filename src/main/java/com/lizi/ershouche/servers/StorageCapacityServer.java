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
    static String filePath="src/main/resources/ershoucheparams/storagecapacity.properties";
    static String serverUrl="/cardealer/storage-capacity/save-buyer";
    static String  cookies="id58=e87rZF+1PI4H5vjWDP6SAg==; 58home=bj; city=bj; 58tj_uuid=e6fb72bb-c713-41d1-9719-faf5e2de9060; new_uv=1; als=0; wmda_uuid=5c7473bd71932710b8dd1bbb9c7610b7; wmda_new_uuid=1; wmda_visited_projects=%3B11187958619315; xxzl_cid=874088ee18324f36960af5b0fd3a24f0; xzuid=200a9c57-a59e-4758-9887-676fb2130e1d; _bu=201805301036147d753980; xinan_auth_agent_bspId=201805301036147d753980; bj58bsp_logininfo=userid%3D201805301036147d753980%26username%3Dzhangjingli%26realname%3D%E5%BC%A0%E6%95%AC%E4%B8%BD%26orgid%3D2017080711103314a25525%26dutyid%3D201101101655507f728cae%26eamil%3D18888812313%26dutyid%3D201101101655507f728cae%26siteTime%3D43BF48950CFCD52FED5852E2346146258DBC5EE505A1468C9%26sitekey%3D1335CC124C80CA317ECF7C7081BDC2C819724522A6C13F1802E998DBBEAE10AD5%26version%3Dv2; JSESSIONID=A841102E0D908B7F9F4656F5205ED107; bj58bsp_login_token_shccrm=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2ppbmdsaSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTYwNzk4NTczMywic3lzIjoic2hjY3JtIiwiaWF0IjoxNjA3OTQyNTMzLCJ1c2VySWQiOiIyMDE4MDUzMDEwMzYxNDdkNzUzOTgwIiwianRpIjoiMjAyMDEyMTQxODQyMTM2YjZmNWExNCIsIm9yZ0lkIjoiMjAxNzA4MDcxMTEwMzMxNGEyNTUyNSIsImVtYWlsIjoiMTg4ODg4MTIzMTMiLCJyZWFsbmFtZSI6IuW8oOaVrOS4vSJ9.5Gh-oCqpXKdE-4qnvMIO2qgdyG37dwmYlzBYfpppBx4";

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
