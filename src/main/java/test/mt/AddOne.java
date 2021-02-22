package test.mt;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lizi
 * @Date: 2020/9/28 4:41 下午
 * 最后一个数字+1
 */
//输入[1,2,9],输出[1,3,0]
public class AddOne {
    public static void main(String[] args) {
        int[] arry={9,0,9};

        int[] ints = plusOne(arry);
        for (int i:ints) {
            System.out.println(i);
        }
    }

    //修改原数组直接加1
   public static  int[] plusOne(int[] arry){
        int n=arry.length;
        for(int i = n-1;i >= 0; i--){
            arry[i]= arry[i]+1;
            if(arry[i]>9){
                arry[i]=0;
            }else {
                break;
            }
        }
        if(arry[0]==0){//最高位是0的话，则数组每位都是9，相当于所有位为0，向上加一位
            arry=new int[n+1];
            arry[0]=1;
        }
        return arry;
    }
}
