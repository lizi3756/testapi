package com.lizi.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @Author: lizi
 * @Date: 2021/3/17 上午9:46
 */
public class Jsontest {
    public static void main(String[] args) {
        String json ="{\"contactName\":\"彭先生\",\"contactPhone\":\"15828008747\"}";
        JSONObject object = JSONObject.parseObject(json);
        Map<Object,Object> map = object.toJavaObject(Map.class);
        for(Map.Entry<Object,Object> m:map.entrySet()){
            System.out.println(m.getKey()+":"+m.getValue());
        }
        String phone = object.get("contactPhone").toString();
        //System.out.println(phone);
    }
    public static void getJson(String json){
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(json)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
