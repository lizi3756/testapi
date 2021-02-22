package com.dubbo.dubbotest;

import com.alibaba.dubbo.rpc.service.GenericService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DubboTest {
    @DataProvider
    public Object[][] getLotteryData(){
        Object[][] data= {
                {"积分抽奖接口-正确",1,10000,"success"},
                {"积分抽奖接口-活动不存在",8888,10000,"活动不存在"},
                {"积分抽奖接口-用户不存在",1,100001,"该用户无积分"},
        };
        return data;
    }

    @Test(description = "积分抽奖接口",dataProvider = "getLotteryData",dataProviderClass = Data.class)
    public void lottery(String casename,int activityId,int userId,String assertValue) {
        GenericService service = ServiceInit.getService("dubbo://192.168.1.4:20880", "cn.testfan.dubbo.service.MarketService", "1.0");
        String[] paramsType= {"java.lang.Integer","java.lang.Integer"};
        Object[] paramsValue= {activityId,userId};
        Object response=service.$invoke("lottery", paramsType, paramsValue);
        System.out.println(response.toString());
        Assert.assertTrue(response.toString().contains("message="+assertValue));
    }
}
