package com.lizi.ershouche;

import com.lizi.utils.PropertyUtil;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

/**
 * @Author: lizi
 * @Date: 2020/12/3 8:38 下午
 */
public class StoreBase {
    public static String url;
    @BeforeClass
    public void init(){
        Properties properties = PropertyUtil.getProperties("src/main/resources/httpuri.properties");
        url=properties.getProperty("http.url");
    }
    @AfterClass
    public void close(){

    }
}
