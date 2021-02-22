package test.mt;

import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lizi
 * @Date: 2021/2/19 下午4:34
 */
public class Target {
    public static void main(String[] args) {
        int[] arr ={1,3,5,2,4,8,7};
        deng1(arr,6);
    }
    //返回元素下标
    public static int[] deng1(int[] arr ,int target){
        int[] arrnew = new int[2];
        Map<Integer ,Integer> map = new HashMap<>();
        for(int i = 0;i< arr.length;i++){
            if(map.containsKey(target-arr[i])){
                arrnew[0] = map.get(target-arr[i]);
                arrnew[1] = i;
                break;
            }
            map.put(arr[i],i);//key是数组元素，value是元素下标
        }
        System.out.println(arrnew[0]+","+arrnew[1]);
        return arrnew;
    }



    //找到数组中2个和等于target的2个数/索引,假设只有一组和满足
    public static int[] deng(int[] arr ,int target){
        int[] arrnew = new int[2];
        for (int j =0;j< arr.length;j++){
            for(int i =0;i< arr.length;i++){
                if(arr[i]!= arr[j]){
                    if( arr[i] + arr[j] == target){
                        arrnew[0] = j;
                        arrnew[1] = i;
                        break;
                    }
                }
            }
            j++;
        }
        System.out.println(arrnew[0]+","+arrnew[1]);
        return arrnew;
    }
}
