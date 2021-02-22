package test.mt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lizi
 * @Date: 2021/2/18 下午4:59
 *
 */
public class DeleteSame1 {
    public static void main(String[] args) {
        int[] arry = {5, 5, 3, 5, 6, 6, 6};
        List<Integer> list1 = deleteSame(arry);
        for (Integer i : list1) {
            System.out.println(i);
        }

    }
    //对数组进行排重
    public static List<Integer> deleteSame(int[] nums) {
        List<Integer> numsnew = new ArrayList<>();
        //numsnew.add(nums[0]);
        for(int i = 0; i < nums.length; i++){
           if(!(numsnew.contains(nums[i]))){
               numsnew.add(nums[i]);
           }
        }
        return numsnew;
    }

    //输出数组中元素为负数的位置
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0){
                res.add(Math.abs(i+1));
                }
        }
        return res;
    }
    //找到数组中元素的个数（重复的算一次）
    //得到deleteSame方法的返回结果后取数组的长度也可以
    public static  int removeDuplicates(int[] nums) {
        int length=nums.length;
        int j=1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1]) //%如果两个相邻的元素相同
            {
                length--;}           //%那么进行压缩，长度减少
            /*else
            {
                nums[j++]=nums[i+1];
            } *///%若两个相邻元素不同，那么对另外一个元素进行存储
        }
        return length;
    }
}
