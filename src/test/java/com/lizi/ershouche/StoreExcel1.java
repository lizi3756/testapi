package com.lizi.ershouche;

import com.lizi.ershouche.servers.StorageCapacityServer;
import data.StoreData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author: lizi
 * @Date: 2020/12/4 5:50 下午
 * 1、server类,正常的一组数据还是要写在properties里面
 * 2、base类
 * 3、
 *    1）数据驱动，只写修改的字段以及值
 *    2）
 * */
public class StoreExcel1 extends StoreBase {
    @Test(dataProvider = "getData",dataProviderClass= StoreData.class,description = "数据在excel中")
    public static void save(String casename,String key,String value,String assertvalue) throws Exception {
        System.out.println(casename);
        String save = StorageCapacityServer.save(url, key, value);
        Assert.assertTrue(save.contains(assertvalue));
    }

}

