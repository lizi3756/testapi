package com.lizi.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lizi
 * @Date: 2020/12/14 下午7:40
 * 代替PropertyUtil类的
 */
public class ProTest {
    private static Map<String, Properties> propFileMap = new ConcurrentHashMap<String, Properties>();

    public static void main(String[] args) throws IOException {
        String property = System.getProperty("user.dir");
        System.out.println(property);
        String fileName=property+"/src/main/resources/httpuri.properties";
        Properties prop=new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf-8"));
        prop.load(br);
        String s = prop.getProperty("http.url");
        System.out.println(s);
        //String property = System.getProperty("user.dir");
        //System.out.println(httpProps.getProperty("http.crm.url"));
        //System.out.println(getAllKeyValue(property+"/src/main/resources/httpuri.properties"));
    }

    public static Properties getProperties(String fileName) {
        Properties prop=new Properties();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf-8"));
            prop.load(br);
            propFileMap.put(fileName, prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return prop;
    }


    public static HashMap<String, String> getAllKeyValue(String file) throws IOException {
        HashMap<String, String> keyValus = new HashMap<String, String>();

        Properties prop = getProperties(file);

        Iterator it =prop.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            keyValus.put(key.toString(), value.toString());
            System.out.println(("get caps " + key.toString() + ":" + value.toString()));
        }
        return keyValus;
    }
}
