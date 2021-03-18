package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lizi
 * @Date: 2021/3/18 下午2:32
 */
//查找
public class Single1 {
    public static void main(String[] args) {
        int[] arr ={3,5,8,-1,6};
        //cha(arr);

        String str = "abcdfeddddd";
        char c = find(str);
        System.out.println(c);

    }
    public static char find(String str){
        char[] chars = str.toCharArray();
        Map<Character ,Integer> map = new HashMap<>();
        for(char c :chars){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }

        Integer list[] =new Integer[map.size()];
        int i = 0;
        for(Integer l :map.values()){
            list[i] = l;
            i++;
        }
        int max = list[0];
        for(int j = 0;j < list.length;j++){
            max = Math.max(max, list[j]);
        }

        for(Map.Entry<Character ,Integer> m:map.entrySet()){
            if(m.getValue() == max){
                return m.getKey();
            }
        }
        return ' ';

    }
   public static int[] cha(int[] arr){
       if(arr.length < 2){
           return arr;
       }
       int[] arrnew = new int[2];
       int num =(arr[1]-arr[0])>(arr[0]-arr[1])?(arr[1]-arr[0]):(arr[0]-arr[1]);
       for(int i =2;i< arr.length;i++){
           int temp  = (arr[i] - arr[i-1]) >(arr[i-1] - arr[i])?(arr[i] - arr[i-1]):(arr[i-1] - arr[i]);

           if(temp > num){
               num =temp;
               arrnew[0] = arr[i-1];
               arrnew[1] = arr[i];
           }
       }
       for(int i :arrnew){
           System.out.println(i);
       }
       return arrnew;
   }
}
