package com.lizi.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class PropertyUtil {

	private static Map<String, Properties> propFileMap = new ConcurrentHashMap<String, Properties>();

	public static void main(String[] args) {
		String property = System.getProperty("user.dir");
		//System.out.println(property);
		//Properties httpProps= com.lizi.utils.PropertyUtil.getProperties(property+"/src/main/resources/httpuri.properties");
		//System.out.println(httpProps.getProperty("http.crm.url"));
		System.out.println(getAllKeyValue(property+"/src/main/resources/httpuri.properties"));
		Properties pro =  new Properties();
		Iterator  it = pro.entrySet().iterator();
	}

	public static Properties getProperties(String fileName) {
		Properties prop=readProperties(fileName);
		if (prop == null) {
			prop = new Properties();
		}

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

	/**
	 * 读取文件里所有参数，返回map对象
	 * @return
	 */
	public static HashMap<String, String> getAllKeyValue(String file) {
		HashMap<String, String> keyValus = new HashMap<String, String>();
		Iterator it = getProperties(file).entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			keyValus.put(key.toString(), value.toString());
			System.out.println(("get caps " + key.toString() + ":" + value.toString()));
		}
		return keyValus;
	}
	private static Properties readProperties(String file){
		Properties properties = new Properties();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			properties.load(bf);
			inputStream.close(); // 关闭流
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		return properties;
	}
}
