package com.lizi.crm.testcases;

import com.alibaba.fastjson.JSONObject;
import com.lizi.crm.servers.AddCustomerCrmServers;

import com.lizi.utils.ExcelDataUtil;
import com.lizi.utils.JSONPathUtil;
import com.lizi.utils.JdbcDataUtil;
import com.lizi.utils.Props;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrmAddCustomerBaseTest extends CrmTestBase{

    @Test(description = "添加客户正常流程")
    public static void test001_add() throws Exception {

        JdbcDataUtil.executeUpdate(conn,"DELETE FROM 72crm_crm_customer where customer_name='栗子123';");
        String res = AddCustomerCrmServers.addCustomer(url,token);
        Assert.assertTrue(res.contains("\"code\":0"));
        JSONObject jsonObject =JSONObject.parseObject(res);
        JSONObject data = jsonObject.getJSONObject("data");
        String expcustomerName = data.getString("customerName");//响应结果里面的内容
        Assert.assertEquals(expcustomerName,"栗子123");
        String customerId = JSONPathUtil.extract(res, "$.data.customerId").toString();
        Props.put("customerId",customerId);//将响应中的客户id作为全局变量，传递给联系人的接口
        Object[][] dbdata = JdbcDataUtil.getData(conn, "SELECT customer_name FROM 72crm_crm_customer ORDER BY customer_id desc LIMIT 1;");
        //得到的结果是一个二维数组
        Assert.assertEquals(dbdata[0][0].toString(),expcustomerName);
    }

    @DataProvider
    public Object[][] data(){
        Object[][] obj={
                {"mobile","1336615389","手机号码格式不正确"},
                {"customer_name","","客户姓名不能为空"}
        };
        return obj;
    }
    @Test(dataProvider = "data")
    public static void test002_adddata(String key,String value,String assertvalue) throws Exception {
        String res = AddCustomerCrmServers.addCustomer(url,token,key,value);
        Assert.assertTrue(res.contains(assertvalue));
    }

    @DataProvider
    public Object[][] exceldata() throws Exception {
        ExcelDataUtil excel =new ExcelDataUtil("src/main/resources/crmparams/crmdata.xlsx");
        Object[][] obj= excel.getTestData("新增客户");

        return obj;
    }
    @Test(dataProvider = "exceldata",description = "数据在excel中")
    public static void test0020_addexceldata(String casename,String key,String value,String assertvalue) throws Exception {

        String res = AddCustomerCrmServers.addCustomer(url,token,key,value);
        Assert.assertTrue(res.contains(assertvalue));
    }

    @Test(description = "手机号码不足11位")
    public static void test002_add() throws Exception {
        String res = AddCustomerCrmServers.addCustomer(url,token,"mobile","1336615389");
        Assert.assertTrue(res.contains("手机号码格式不正确"));
    }

    @Test(description = "客户姓名为空")
    public static void test003_add() throws Exception {
        String res = AddCustomerCrmServers.addCustomer(url,token,"customer_name","");
        Assert.assertTrue(res.contains("客户姓名不能为空"));
    }
}
