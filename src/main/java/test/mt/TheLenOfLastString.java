package test.mt;

/**
 * @Author: lizi
 * @Date: 2020/9/28 4:55 下午
 */
//给定一个字符串，计算最后一个单词的长度
public class TheLenOfLastString {

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("  sdfjnfe  hdnec  bdejec     "));
    }
    public static int lengthOfLastWord(String s){
        String[] s1 = s.trim().split("\\s+");
        System.out.println("长度为："+s1.length);
        if(s1.length==0){
            System.out.println("请输入字符串");
            return 0;
        }else {
             return s1[s1.length - 1].length();
        }
    }
    //判断一个字符串中最后一个单词的长度
    public static int lengthOfLastWord1(String s){
        String[] str =s.trim().split(" ");
        System.out.println(str.length);
        if(str.length==0){
            return 0;
        }else {
            return str[str.length-1].length();
        }

    }
}
