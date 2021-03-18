package test.mt;

import java.lang.reflect.Array;

/*
 * @author lizi

 * @date  2020/9/25 18:19
 */
//8大排序算法
public class PaiXu {
    public static void main(String[] args) {
        /*int[] a = { 6, 9, 0, 4, 5};
        int[] sort = sort3(a);
        for(int i:sort){
            System.out.println(i);
        }*/
        int[] arr = {10,4,7,6,19};
        sortcha(arr);
        quickSort(arr, 0, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //算法1：冒泡排序，把最大的放后面
    public static int[] sort1(int[] arry){
        int n=arry.length;
        //外层控制循环次数，n次
        for(int i = 0;i < n-1; i++){
            for(int j = 0; j < n-1-i; j++){
                if(arry[j] > arry[j+1]){
                    int temp = arry[j+1];
                    arry[j+1] = arry[j];
                    arry[j] = temp;
                }
            }
        }
        return arry;
    }
    //把最小的放后面
    public static int[] sort2(int[] arry){
        int n=arry.length;
        //外层控制循环次数，n次
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arry[j]<arry[j+1]){
                    int temp=arry[j+1];
                    arry[j+1]=arry[j];
                    arry[j]=temp;
                }
            }
        }
        return arry;
    }
    //算法2：选择排序，把每次循环的第一个值记为最小
    public static int[] sort3(int[] arry){
        int n=arry.length;
        if(n<=0){
            return null;
        }
        for(int i=0;i<n;i++){
            int minIndex=i;//每次循环指定一个最小值的索引
            for(int j=i;j<n;j++){
                if(arry[j]<arry[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arry[i];
            arry[i]=arry[minIndex];
            arry[minIndex]=temp;
        }
        return arry;
    }
    public static int[] sort31(int[] arry) {//循环次数
        for(int i =0;i< arry.length;i++){
            int t = i,temp;
            for(int j=i;j< arry.length;j++){
                if (arry[j]< arry[t]){
                    t = j;//标记每一次循环的最小的值
                }
            }
            temp = arry[i];
            arry[i] = arry[t];
            arry[t] = temp;
        }
        return arry;
    }

    //算法4：
    public static int[] sort4(int[] arry){
    return null;
    }
    //快速排序,左右游标
    public static void quickSort(int[] arr,int low,int high){
            int i,j,temp,t;
            if(low>high){
                return;
            }
    i=low;//游标
    j=high;
    //temp就是基准位
    temp = arr[low];

            while (i<j) {
        //先看右边，依次往左递减
        while (temp<=arr[j]&&i<j) {
            j--;
        }
        //再看左边，依次往右递增
        while (temp>=arr[i]&&i<j) {
            i++;
        }
        //如果满足条件则交换
        if (i<j) {
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }

    }
    //最后将基准位与i和j相等位置的数字交换
    arr[low] = arr[i];
    arr[i] = temp;
    //递归调用左半数组
    quickSort(arr, low, j-1);
    //递归调用右半数组
    quickSort(arr, j+1, high);
}
    public static void quick(int[] arr,int low ,int hight){
        int base = arr[low];
        int i=low , j = hight ;//左右游标
        while(i < j ){
            while( arr[j] >= base && i < j){
                j--;
            }
            while( arr[i] <= base && i < j){
               i++;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[low] = arr[i];
        arr[i] = base;
        quick(arr , low , i-1);
        quick(arr , i+1 , hight);


    }
    public static void quickSort4(int[] arr,int low,int high){

    }
    //插入排序，标记第一个，和前面的一次对比，大于则交换
    public static int[] sortcha(int[] arry){

        for(int i=1; i<arry.length; i++){
            int temp = arry[i];//保存每次需要插入的那个数
            int j;
            for(j=i; j>0&&arry[j-1]>temp; j--){//这个较上面有一定的优化
                arry[j] = arry[j-1];//吧大于需要插入的数往后移动。最后不大于temp的数就空出来j
            }
            arry[j] = temp;//将需要插入的数放入这个位置
        }
        return arry;
    }

    public static int[] sortcha1(int[] arry) {
        int j;

       for(int i =1;i< arry.length ;i++){
           int temp = arry[i];
           for(j = i;j > 0 && arry[j-1]>temp;j-- ){
               arry[j] = arry[j-1];
           }

           arry[j] = temp;
       }
       return  arry;

    }

}
