package test.solution;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.abs;

/**
 * @Author: lizi
 * @Date: 2021/2/24 下午1:59
 */
public class Niu {

    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 0, 4, 7, 0};
        zero(arr);
       // System.out.println(cha(arr));
    }
    //列表中为0的元素放在末尾
    public static int[] zero(int[] arr){
        int[] nums = arr;
        int j = arr.length - 1;
        for(int i = 0 ;i < arr.length ;i++){
            if(i>=j){
                break;
            }
            if(nums[i] == 0){
                while (nums[j]==0){
                    j--;
                }
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] =t;
            }

        }
        for(int i : nums){
            System.out.println(i);
        }
        return nums;
    }
    //int数组，差值最大的相邻的2个数
    public static int[] cha(int[] arr){
        int max = 0;
        int[] nums = new int[2];
        for(int i = 0 ; i < arr.length -1;i++){
            if(abs(arr[i] - arr[i+1]) > max){
                max = abs(arr[i] - arr[i+1]);
                nums[0] = arr[i];
                nums[1] = arr[i+1];
            }
        }
        System.out.println(nums[0]+";"+nums[1]);
        return nums;
    }

    //找出不重复的数字
    public static int noReat(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() != 0 && m.getValue() < 2) {
                return m.getKey();
            }
        }
        return -1;
    }

    //找出一个字符串中top2出现的字母
    public static int noReat1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
            List<Integer> list = new ArrayList();
            for (Integer l : map.values()) {
                list.add(l);
            }
            int max = 0;
            int max_sce = 0;
            for (int i = 0; i < list.size(); i++) {
                max = list.get(i) > max ? list.get(i) : max ;
                max_sce = (list.get(i) < max && list.get(i) > max_sce) ? list.get(i) : max_sce;
            }

        /*for(Map.Entry<Character,Integer> m : map.entrySet()){
            if(m.getValue()!= 0 && m.getValue() < 2){
                return m.getKey();
            }
        }*/

            return max_sce;
        }

        public static int noRept ( int[] arr){
            int num = arr[0];
            for (int i = 1; i < arr.length; i++) {
                num = num ^ arr[i];
            }
            return num;
        }
        //找出列表中2数相加之和=target
        public static int[] find ( int[] arr, int target){
            int[] nums = new int[2];
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] + arr[j] == target) {
                        nums[0] = i;//返回索引
                        nums[1] = j;
                        break;
                    }
                }
            }
            return nums;
        }

    }
