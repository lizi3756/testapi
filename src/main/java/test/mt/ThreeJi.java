package test.mt;

import java.util.*;

/*
 * @author lizi

 * @date  2020/9/25 18:21
 */
//数组中3个数乘积最大的值
public class ThreeJi {
    public static void main(String[] args) {
        int[] arry={-4,-9,4,2,0,1,5,8};
        int[] num2 = {4,2,5,4};
        Set<Integer> set = new HashSet<>();
        for(int i=0;i< num2.length;i++){
            set.add(num2[i]);
        }
       /* for(Integer i : set){
            System.out.println(i);
        }*/
        //System.out.println(set.size());

        //System.out.println(maxThree(arry));
        int[] jiaoji = jiaoji(arry, num2);
        for(int i: jiaoji){
            System.out.println(i);
        }

    }

    public static int maxThree(int[] arry){
        int n=arry.length;
        Arrays.sort(arry);
        return Math.max(arry[n-1]*arry[n-2]*arry[n-3],arry[0]*arry[1]*arry[n-1]);
    }

    //2个数组的交集
    public static int[] jiaoji(int[] num1, int[] num2){
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i: num1){//把数组一放到set中
            set.add(i);
        }
        for(int i = 0 ; i < num2.length ;i++){
            if(set.contains(num2[i]) && !(list.contains(num2[i]))){//遍历数组2，如果数组1中存在数组2的元素，则添加到list中
                list.add(num2[i]);
            }
        }
        int[] newNum = new int[list.size()];//将list换成数组
        for(int i = 0;i < list.size(); i++){
            newNum[i] = list.get(i);
        }
        return newNum;
    }
}
