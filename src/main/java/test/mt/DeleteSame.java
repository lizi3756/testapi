package test.mt;


import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: lizi
 * @Date: 2020/9/28 8:20 下午
 *
 */
public class DeleteSame {
    public static void main(String[] args) {
        String[] arr = {"aa","bb","aa","cc"};
        Integer[] arr1 = {1,1,2,3,3};
        /*List<String> strings = deleteSame(arr);
        for(String s:strings ){
            System.out.println(s);
        }*/
        dealets(arr1);
    }
    /*public static void dealets(int[] str){
        Set<Integer> set = new HashSet<>();
        for(int s :str){
            set.add(s);
        }
        for(int s :set){
            System.out.println(s);
        }
    }*/
    public static <T>void dealets(T[] str){
        Set<T> set = new HashSet<>();
        for(T s :str){
            set.add(s);
        }
        for(T s :set){
            System.out.println(s);
        }
    }


    //删除数组字符串中一样的元素，并把排重后的输出
    public  static <T> List<T> deleteSame(T[] str){
        List<T> newstr = new ArrayList<>();
        for(int i =0; i< str.length;i++){
            if(!(newstr.contains(str[i]))){
                newstr.add(str[i]);
            }
        }
        return newstr;
    }
    //对数组进行排重
    public static List<Integer> deleteSame1(int[] nums) {
        List<Integer> numsnew = new ArrayList<>();
        //numsnew.add(nums[0]);
        for(int i = 0; i < nums.length; i++){
            if(!(numsnew.contains(nums[i]))){
                numsnew.add(nums[i]);
            }
        }
        return numsnew;
    }




}
