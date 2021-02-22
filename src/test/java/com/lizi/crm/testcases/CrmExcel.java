package com.lizi.crm.testcases;

import com.alibaba.fastjson.JSONObject;
import com.lizi.utils.ExcelDataUtil;
import com.lizi.utils.JSONPathUtil;
import com.lizi.utils.MyHttpClient;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CrmExcel extends CrmTestBase{
    public static void main(String[] args) throws Exception {
        //ExcelDataUtil excel =new ExcelDataUtil("src/main/resources/crmparams/CRMTest.xlsx");
        //如果是表单的post接口，在excel中，参数的格式为{"username":"admin","password":"123456"}，转成json格式
       // Object[][] obj= excel.getTestData("CRM登录");
        /*for(int i=0;i<obj.length;i++){
            for(int j=0;j<obj[0].length;j++){
                System.out.println(obj[i][j]);
            }
        }*/

        String params="{\"username\":\"admin\",\"password\":\"123456\"}";
        JSONObject jsonObject=JSONObject.parseObject(params);
        Map<Object,Object> map = jsonObject.toJavaObject(Map.class);

        for(Map.Entry<Object,Object> entry:map.entrySet()){
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }
    }
    @DataProvider
    public static Object[][] getdata() throws Exception {
        ExcelDataUtil excel =new ExcelDataUtil("src/main/resources/crmparams/CRMTest.xlsx");
        //如果是表单的post接口，在excel中，参数的格式为{"username":"admin","password":"123456"}，转成json格式
        Object[][] obj= excel.getTestData("CRM登录");
        excel.close();
        return obj;
    }
    @Test(dataProvider = "getdata")
    public void test001_crmtest(String casename,String serverUrl,String method,String header,String params,String assertValue) throws Exception {
        String ContentType= JSONPathUtil.extract(header,"$.Content-Type").toString();
        String res="";
        if(method.equalsIgnoreCase("get")){

        }else if(method.equalsIgnoreCase("post")){
            Map<String,String> headers=new HashMap<String, String>();
            headers.put("Admin-token",token);
            headers.put("Content-Type",ContentType);
            if(ContentType.contains("application/json")||ContentType.contains("text/xml")){
                res = MyHttpClient.sendPostJsonOrXml(url + serverUrl, headers, params);
            }else if(ContentType.contains("application/x-www-form-urlencoded")){
                JSONObject jsonObject=JSONObject.parseObject(params);
                Map map = jsonObject.toJavaObject(Map.class);
                res = MyHttpClient.sendPost(url + serverUrl, headers, map);
            }
        }
            Assert.assertTrue(res.contains(assertValue));
    }
}

