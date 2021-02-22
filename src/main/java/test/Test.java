package test;
/*
 * @author lizi

 * @date  2020/8/11 18:06
 */

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        //String str[]= new String[]{"abc", "abc","abc","bcd","bcd"};
       // find(str);
        //System.out.println( lengthOfLastWord("  heool world "));
       // String s="zhang";
        //System.out.println(s.length());
        int[] data1=new int[]{9,9,9,0,0,0};
        int[] data2=new int[]{1,2,3};
        merge(data1,3,data2,3);
        //int[] ints = plusOne(data);
       /* for (int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }*/
        String s1=null;
        System.out.println(StringUtils.isEmpty(s1));
        System.out.println(StringUtils.isBlank(s1));
    }


    public  static void merge(int[] nums1,int m,int[] nums2,int n){
        for(int i=m;i<m+n;i++){
            nums1[i]=nums2[i-n];
        }
        /*for (int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }*/
        //Arrays.sort(nums1);
        for (int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
    }

    //输入[1,2,3],输出[1,2,4]
    public static  int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int x = digits[i] + 1;
            if (x <= 9) {
                digits[i] = x;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static  void  find(String str[]){

        Map<String,Integer> map =new HashMap<String,Integer>();
        for (String s: str) {
            if(!s.equals(" ")){
                if(!map.containsKey(s)){//map里面没有，就增加，有的话，就+1
                    map.put(s,1);
                }else {
                    map.put(s,map.get(s)+1);
                }

            }
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println("key="+entry.getKey()+" and value "+entry.getValue());
        }

    }
}
