package test.solution;
/*
 * @author lizi

 * @date  2021/2/22 22:05
 */

public class Salary {

    public static void main(String[] args) {
        int[] arr ={1,2,3,4};
        int[] ints = pailie(arr);
        for(int i:ints){
            System.out.println(i);
        }
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
