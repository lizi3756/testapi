package test.mt;


import java.util.Arrays;

/*
 * @author lizi

 * @date  2020/9/25 16:06
 */

public class Qiuhe2 {
    public static void main(String[] args) {
        int[] arry={5,2,8,4,6,10};
        int[] ints = getNum1(arry, 10);
        for(int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }
    //排序，返回下标
    public static int[] getNum1(int[] arry,int target){
        int first=0,second=0,text,i,j;
        int n=arry.length;
        for(i=0;i<n;i++){
            first=i;
            text=target-arry[i];
            for(j=i+1;j<n;j++){//判断剩下的里面包不包含text
                if(arry[j]==text){
                    second=j;
                    break; }
            }
            if(j==n){
                continue;
            }else {
                break;
            }
        }
        int[] arry_new=new int[2];
        arry_new[0]=first;
        arry_new[1]=second;
        return arry_new;
    }
    //排序，返回值
   public static int[] getNum2(int[] arry,int target){
    int n=arry.length;
    int[] arry_new=new int[2];
    Arrays.sort(arry);
    for(int i=0,j=n-1;i<j;){
        if(arry[i]+arry[j]==target){
            arry_new[0]=arry[i];
            arry_new[1]=arry[j];
            return arry_new;
        }else if(arry[i]+arry[j]<target){
            i++;
        }else {
            j--;
        }
    }
    return  null;
   }
}
