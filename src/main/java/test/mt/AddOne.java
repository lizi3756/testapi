package test.mt;


import org.apache.commons.io.input.ReaderInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lizi
 * @Date: 2020/9/28 4:41 下午
 * 最后一个数字+1
 */
//输入[1,2,9],输出[1,3,0]
public class AddOne {
    public static void main(String[] args) {
        int[] arry={1,2,3,5,6,8,9};

        /*int[] ints = plusOne(arry);
        for (int i:ints) {
            System.out.println(i);
        }*/
        countn("/Users/zhangjingli/Documents/1.txt");
    }
    public static void countn(String filePath){
        File file =  new File(filePath);
        BufferedReader br = null;
        String s =null;
        Map<String,Integer> map =  new HashMap<>();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while(( s = br.readLine())!= null){
                String[] split = s.split("\\s+");
                for(String s1 :split){
                    if(!s1.isEmpty() ){//排除里面有空行的情况

                        if(map.containsKey(s1)){
                            map.put(s1,map.get(s1)+1);
                        }else {
                            map.put(s1,1);
                        }
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for(Map.Entry<String,Integer> entity:map.entrySet()){
            System.out.println(entity.getKey()+":"+entity.getValue());
        }
        System.out.println(map.get(""));

    }


    //字符串为'abcdefgabcd'，返回第一个不重复的字符
    public static char norepet(String s){
        int len  = s.length();
        for(int i = 0;i <len -1 ; i++){
          if(s.indexOf( s.charAt(i)) == s.lastIndexOf(s.charAt(i)))  {
              return s.charAt(i);

          }
        }
        return ' ';
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
    public static int er(int[] arr,int target){
        int len = arr.length;
        int left =0;
        int rigth = len -1 ;
        int mid ;
        while(left <= rigth){
            mid = (left + rigth)/2;
            if(arr[mid] > target){
                rigth = mid -1 ;
            }else if(arr[mid] < target){
                left = mid + 1 ;
            }else {
                return mid;
            }
        }

        return -1;
    }
    //回文
    public static  boolean hui(int num){
        int t = num;
        int temp;
        int sum =0;
        while(num !=0){
            temp = num % 10 ;
            sum = sum *10 + temp;
            num = num / 10;
        }

        return sum == t;
    }
}
