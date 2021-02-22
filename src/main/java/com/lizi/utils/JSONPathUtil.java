package com.lizi.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.apache.log4j.Logger;

public class JSONPathUtil {

  static Logger log = Logger.getLogger(com.lizi.utils.JSONPathUtil.class.getName());

	public static <T> T extract(String json, String jsonPath) {
		try {
			Object document = Configuration.defaultConfiguration().jsonProvider().parse(json); // 先解析
			return JsonPath.read(document, jsonPath);
		} catch (Exception e) {
			log.error("jsonpath error, jsonpath=" + jsonPath + " json=" + json, e);
			return null;
		}
	}
	public static void main(String[] args) {
		//String jsonString="{\"code\":0,\"data\":{\"customerName\":\"sdfff\",\"customerId\":34}}";
		String jsonString="{\n" +
				"    \"timestamp\":\"2020-12-03 21:05:10\",\n" +
				"    \"status\":400,\n" +
				"    \"error\":\"Bad Request\",\n" +
				"    \"errors\":[\n" +
				"        {\n" +
				"            \"codes\":[\n" +
				"                \"Min.vendorStorageCapacityConfigVO.typeAMaxCount\",\n" +
				"                \"Min.typeAMaxCount\",\n" +
				"                \"Min.java.lang.Integer\",\n" +
				"                \"Min\"\n" +
				"            ],\n" +
				"            \"arguments\":[\n" +
				"                {\n" +
				"                    \"codes\":[\n" +
				"                        \"vendorStorageCapacityConfigVO.typeAMaxCount\",\n" +
				"                        \"typeAMaxCount\"\n" +
				"                    ],\n" +
				"                    \"arguments\":null,\n" +
				"                    \"defaultMessage\":\"typeAMaxCount\",\n" +
				"                    \"code\":\"typeAMaxCount\"\n" +
				"                },\n" +
				"                \"0\"\n" +
				"            ],\n" +
				"            \"defaultMessage\":\"A类最大保有量 不能小于0\",\n" +
				"            \"objectName\":\"vendorStorageCapacityConfigVO\",\n" +
				"            \"field\":\"typeAMaxCount\",\n" +
				"            \"rejectedValue\":-1,\n" +
				"            \"bindingFailure\":false,\n" +
				"            \"code\":\"Min\"\n" +
				"        }\n" +
				"    ],\n" +
				"    \"message\":\"Validation failed for object='vendorStorageCapacityConfigVO'. Error count: 1\",\n" +
				"    \"path\":\"/cardealer/storage-capacity/save-buyer\"\n" +
				"}";


		//System.out.println(extract(jsonString,"$.errors.defaultMessage").toString());
		String s = extract(jsonString, "$.errors").toString();
		JSONArray jsonArray=JSONArray.parseArray(s);
		String s1 = jsonArray.get(0).toString();

		JSONObject jsonObject=JSONObject.parseObject(s1);
		String defaultMessage = jsonObject.getString("defaultMessage");
		System.out.println(defaultMessage);
	}
}
