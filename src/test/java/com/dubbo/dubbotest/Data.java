package com.dubbo.dubbotest;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider
    public Object[][] getLotteryData(){
        Object[][] data= {
                {"积分抽奖接口-正确",1,10000,"success"},
                {"积分抽奖接口-活动不存在",8888,10000,"活动不存在"},
                {"积分抽奖接口-用户不存在",1,100001,"该用户无积分"}
        };
        return data;
    }
}
