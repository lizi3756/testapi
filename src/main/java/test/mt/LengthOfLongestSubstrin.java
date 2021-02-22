package test.mt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: lizi
 * @Date: 2020/9/30 9:50 上午
 * 无重复字符串的最长字串
 */
public class LengthOfLongestSubstrin {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring3("abcad");//bcda，4
        //System.out.println(length);
        int l = lengthOfString1("ab bbb djlklk  ");
        System.out.println(l);
    }
    //没看懂
    public static  int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int max = 0;
        while(j < n) {
            if (map.containsKey(s.charAt(j))) {
                //直接将左边界右移到重复字符的后一格,如果重复元素在边界i左边则i不变
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j++); // 新元素会覆盖重复元素
            max = Math.max(max, j - i);
        }
        return max;
    }
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int i = 0, j = 0;
        int max = 0;
        while(j < n) {
            // 当前滑动窗口内无重复元素，右边界j一直右移
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            } else { // 遇到窗口内已有的元素，左边界i一直右移直到重复元素不在Set内
               while(set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            max = Math.max(max, j - i);
        }

        return max;
    }
    public static int lengthOfLongestSubstring3(String s){
        int n = s.length();
        int i = 0,j = 0;//i为左边界，j为右边界；
        int max = 0;//无重复的字符串长度
        Set<Character> set=new HashSet<>();//存放字符串
        while(j < n){
            if(!set.contains(s.charAt(j))){//不存在重复的字符串，则将字符串放到set里面，长度+1
                set.add(s.charAt(j));
                j++;
            }else {//存在重复的字符串，则将左边界的字符串去掉，左边界右移一位
                set.remove(s.charAt(i));
                i++;
            }
            max =Math.max(max,j-i);
        }
        return max;
    }
    //字符串中最后一个单词的长度
    public static int lengthOfString(String s){
        int length = s.length();
        if(length<=0){
            return 0;
        }
        int count =0;
        for(int i = length-1;i >=0 ;i-- ){
            if(s.charAt(i)==' '&& count ==0){
                continue;//如果最后一个是空格，结束当前循环
            }
            if(s.charAt(i)!=' '){
                count++;//找到不为空格的字符，并+1
            }else {//再次找到空格字符，则结束
                break;
            }
        }
        return count;
    }
    public static int lengthOfString1(String s){
        String[] split = s.split("\\s+");
        int length = split[split.length - 1].length();
        return length;
    }
}
