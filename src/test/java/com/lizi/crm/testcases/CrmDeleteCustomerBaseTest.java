package com.lizi.crm.testcases;

import com.lizi.crm.servers.AddContactCrmServers;
import com.lizi.crm.servers.AddCustomerCrmServers;
import com.lizi.crm.servers.DeleteCustomerCrmServers;
import com.lizi.utils.JSONPathUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrmDeleteCustomerBaseTest extends CrmTestBase{
    @Test
    public static void test001_deleteCustomer() throws Exception {
        //增加客户
        String customerRes = AddCustomerCrmServers.addCustomer(url, token);
        //得到客户id
        String customerId= JSONPathUtil.extract(customerRes, "$.data.customerId").toString();
        //将新增客户产生的id传给新增联系人的接口
        String contactRes = AddContactCrmServers.addContact(url, token, "customer_id", customerId);
        Assert.assertTrue(contactRes.contains("\"code\":0"));
        //删除新增的客户ID，该客户id已经存在联系人
        String deleteCustomerRes = DeleteCustomerCrmServers.deleteCustomer(url, token, "customerIds", customerId);
        Assert.assertTrue(deleteCustomerRes.contains("该条数据与其他数据有必要关联，请勿删除"));
    }
}
