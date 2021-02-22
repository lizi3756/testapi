package com.dubbo.dubbotest;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;

/** 

* @author 作者栗子

* @version 创建时间：2020年7月17日 下午3:24:51

*/
public class ServiceInit {
	
	public static GenericService getService(String url,String interfaceName,String version) {
		ReferenceConfig<GenericService> refere;
		refere=new ReferenceConfig<GenericService>();
		refere.setApplication(new ApplicationConfig("test"));
		refere.setGeneric(true);
		refere.setTimeout(20000);
		refere.setVersion(version);
		refere.setUrl(url);
		refere.setInterface(interfaceName);
		ReferenceConfigCache cache=ReferenceConfigCache.getCache();
    	GenericService service=cache.get(refere);
    	return service;
	}

}
