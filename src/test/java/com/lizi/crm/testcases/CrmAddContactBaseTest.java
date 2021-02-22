package com.lizi.crm.testcases;

import com.lizi.crm.servers.AddContactCrmServers;
import com.lizi.utils.Props;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrmAddContactBaseTest extends CrmTestBase{
    @Test(description = "添加联系人正常流程")
    public static void test001_addContact() throws Exception {
        String res = AddContactCrmServers.addContact(url, token);
        Assert.assertTrue(res.contains("\"code\":0"));
    }
    @Test(description = "关联联系人正常流程")
    public static void test002_addContact() throws Exception {
        String customerId = Props.get("customerId");//增加客户接口生成的客户id
        String res = AddContactCrmServers.addContact(url, token,"customer_id",customerId);
        Assert.assertTrue(res.contains("\"code\":0"));
    }
}
