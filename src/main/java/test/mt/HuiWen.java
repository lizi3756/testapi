package test.mt;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: lizi
 * @Date: 2020/9/28 6:30 下午
 * 判断是不是回文
 */
public class HuiWen {
    public static void main(String[] args) {

        System.out.println(reverse1("ab cdef g"));
    }
    //int转成字符串，然后将字符串反转，做对比
    public static boolean isPalindrome1(int x){
        String str1=String.valueOf(x);
        // String str2 = new StringBuffer(str1)将字符串转成StringBuffer，为了使用reverse方法
        String str2 = new StringBuffer(str1).reverse().toString();
        return str1.equals(str2);
    }

    public static boolean isPalindrome2(int x){
        if(x <= 0){
            return false;
        }
        int sum = 0,last = 0, temp = x;
        while (temp!=0){
            last = temp % 10;
            sum = sum*10 + last;
            temp = temp/10;
        }
        return x == sum;
    }
    public static boolean isPalindrome3(String str){
        //去空格，大写转小写后，反序输出
        str=str.toLowerCase();
        System.out.println("s1:"+str);
        str=str.replaceAll("[^a-z0-9]","");
        System.out.println("s2:"+str);
        StringBuilder sb =new StringBuilder(str);
        boolean equals = str.equals(sb.reverse().toString());
        return equals;
    }
    //字符串反序输出
    public static StringBuilder reverse1(String s) {
        //String s = "ab cdef g";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0; i--) {
            char tmp = s.charAt(i);
            //System.out.println(tmp);
            sb.append(tmp);
        }
        System.out.println(sb);
        return sb;
    }
}
