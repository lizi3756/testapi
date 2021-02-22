package test.solution;
/*
 * @author lizi

 * @date  2021/2/22 22:37
 * 排序算法
 */

public class Sort {
    public static void main(String[] args) {
        int[] arr ={6,5,4,3,2,1};
        select(arr);
    }
    //选择排序
    public static int[] select(int[] arr){
       for(int i = 0 ; i< arr.length ; i++){
           int min =i;
           for(int j =i+1 ;j<arr.length;j++){
               if(arr[j] < arr[min]){
                    min =j;
               }
           }
           if(min != i){
               int t =arr[i];
               arr[i] = arr[min];
               arr[min] =t;
           }
       }
        System.out.println("排序后：");
        for(int i:arr){
            System.out.print(i + " ");
        }
       return arr;

    }
    //冒泡算法，最小的排在前面
    public static int[] bubble(int[] arr){
        System.out.println("初始排列");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        //i控制循环次数
        for(int i = 0;i< arr.length-1;i++){
            //每次循环会找出最大的放在最后，所以后面的循环可以减去和最后的大的对比
            for(int j=0;j < arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int t= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }

            }
        }
        System.out.println("排序后：");
        for(int i:arr){
            System.out.print(i + " ");
        }
        return arr;
    }
}
