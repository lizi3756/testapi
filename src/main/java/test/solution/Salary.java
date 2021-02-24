package test.solution;
/*
 * @author lizi

 * @date  2021/2/22 22:05
 */

import java.util.ArrayList;
import java.util.List;

public class Salary {


    public static void main(String[] args) {
        int[] arr ={5,2,8,4};
        /*int[] ints = pailie(arr);
        for(int i:ints){
            System.out.println(i);
        }*/
       y(7);

    }

    //杨辉三角
    public static List<List<Integer>>  y(int num){
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 1 ; i <= num ; i++){ //i表示第几行
            List<Integer> list = new ArrayList<>();
            for(int j =0 ; j < i ;j++){//就表示每行内的元素
                if(j == 0 || j == i -1){//每行的第一个和最后一个都是1
                    list.add(1);
                }else {//其余的把上行的j和j-1的值相加
                    list.add(lists.get(i-1-1).get(j-1)+ lists.get(i-1-1).get(j));
                }
            }
            lists.add(list);//把每一行都加到lists里面
        }
        for(List<Integer> list: lists){
            System.out.println(list);
        }
        return lists;
    }
    //股票的最大利润
    public static int maxProfit1(int[] prices){
        int min =prices[0];
        int max = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i]- min;
            }
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int maxPro = 0;//记录最大利润
        int min = prices[0];//记录数组中访问过的最小值
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxPro = Math.max(prices[i] - min, maxPro);
        }
        return maxPro;
    }
    //按照奇偶数组排列
    public static int[] pailie(int[] arr){
        int ji=1;
        int ou =0;
        for(;ou<arr.length;ou+=2){
            if(arr[ou]%2==0){
                continue;
            }
            while (arr[ji]%2!=0){
                ji+=2;
            }
            int t = arr[ou];
            arr[ou] = arr[ji];
            arr[ji] =t;
        }
        return arr;
    }

    //去掉最低和最高工资的平均工资
    public static float salary(int[] arr){

        int max= arr[0],min=arr[0],sum =0;
        for(int i = 0 ;i< arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                max = arr[i];
            }
            sum += arr[i];
        }
        float ave = (sum -max - min)/(arr.length-2);
        return ave;
    }
}
