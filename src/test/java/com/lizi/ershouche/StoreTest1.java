package com.lizi.ershouche;


import com.alibaba.fastjson.JSONObject;
import com.lizi.ershouche.servers.StorageCapacityServer;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author: lizi
 * @Date: 2020/12/3 8:41 下午
 */
public class StoreTest1 extends StoreBase {
    @Test(description = "正常流程")
    public void test001_Store() throws Exception {
        String save = StorageCapacityServer.save(url);
        Assert.assertTrue(save.contains("保存成功"));
        System.out.println("save:"+save);
    }
    @Test(description = "abcd潜客之和大于总量")
    public void test002_Store() throws Exception {
        String save = StorageCapacityServer.save(url,"typeAMaxCount","1000");
        JSONObject jsonObject=JSONObject.parseObject(save);
        String actual_tag = jsonObject.getString("tag");
        Assert.assertEquals(actual_tag, "A,B,C,D和潜客最大保有量的总数不能大于电子签客户最大保有量!");
        System.out.println("save:"+save);
    }
    @Test(description = "数据为负数")
    public void test003_Store() throws Exception {
        String save = StorageCapacityServer.save(url,"typeAMaxCount","-1");

        /*String actual_errors = JSONPathUtil.extract(save, "$.errors").toString();
        JSONArray jsonArray =JSONArray.parseArray(actual_errors);
        String s = jsonArray.get(0).toString();

        String arguments = JSONPathUtil.extract(s, "$.arguments").toString();
        JSONArray argumentsjson =JSONArray.parseArray(arguments);
        String s1 = argumentsjson.get(0).toString();
        String code = JSONPathUtil.extract(s1, "$.code").toString();
        System.out.println("code:"+code);*/
        Assert.assertTrue(save.contains("A类最大保有量 不能小于0"));

    }

}
