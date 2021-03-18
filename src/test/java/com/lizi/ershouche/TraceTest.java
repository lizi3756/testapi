package com.lizi.ershouche;

import com.dubbo.dubbotest.Data;
import com.lizi.ershouche.servers.TraceServers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author: lizi
 * @Date: 2020/10/19 6:03 下午
 */
public class TraceTest extends TraceBase{
    @Test(description = "正常流程")
    public void test001() throws Exception {
        String result = TraceServers.trace(url);
        System.out.println(result);
    }
    @Test(description = "联系人为空")
    public void test002() throws Exception {
        String result = TraceServers.trace(url,"agentName","");
        System.out.println(result);
    }
    @Test(description = "详情为空")
    public void test003() throws Exception {
        String result = TraceServers.trace(url,"content","");
        System.out.println(result);
    }



    @DataProvider
    public static Object[][] getData(){
        Object[][] data={{"content","","\"status\":200"},
                {"agentName","","\"status\":200"}};
        return data;
    }

    //数据驱动
    @Test(dataProvider = "getData")
    public void test00(String key,String value,String assertValue) throws Exception {
        String result = TraceServers.trace(url,key,value);
        System.out.println(result);
    }

}
