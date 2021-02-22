package test;
/*
 * @author lizi

 * @date  2020/9/16 19:23
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hsahmap {
    public static Map<String ,String> map=new HashMap<String ,String>();

    public static void main(String[] args) {
        map.put("ershoucheparams","aaa");
        map.put("2","bbb");
        map.put("3","ccc");
        //1
        for (String s:map.keySet()) {
            System.out.println(s);
        }
        //2
        for (String s:map.values()) {
            System.out.println(s);
        }
        //3
        Set<Map.Entry<String, String>> entries =  map.entrySet();
        for (Map.Entry<String, String> en: entries) {
            System.out.println(en.getKey()+"="+ en.getValue());

        }
    }
}
