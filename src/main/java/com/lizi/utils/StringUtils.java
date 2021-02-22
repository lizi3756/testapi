package com.lizi.utils;

/**
 * @Author: lizi
 * @Date: 2020/11/5 6:44 下午
 */
public class StringUtils {
    public static String trimFirstAndLastChar(String str, String element){
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do {
            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;//判断元素首次出现的位置
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            System.out.println(str);
            beginIndexFlag = (str.indexOf(element) == 0);
            endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
        } while (beginIndexFlag || endIndexFlag);
        return str;
    }

    public static void main(String[] args) {
        String s = trimFirstAndLastChar1("]h]kjsdk]nc]", "]");
        System.out.println(s);
    }
    public static String trimFirstAndLastChar1(String str, String element){

            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;//判断元素首次出现的位置
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            System.out.println(str);
            return str;
    }
}
