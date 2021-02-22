package test.mt;
/*
 * @author lizi

 * @date  2020/9/25 18:19
 */
//8大排序算法
public class PaiXu {
    public static void main(String[] args) {
        int[] a = { 6, 9, 0, 4, 5};
        int[] sort = sort3(a);
        for(int i:sort){
            System.out.println(i);
        }
    }

    //算法1：冒泡排序，把最大的放后面
    public static int[] sort1(int[] arry){
        int n=arry.length;
        //外层控制循环次数，n次
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arry[j]>arry[j+1]){
                    int temp=arry[j+1];
                    arry[j+1]=arry[j];
                    arry[j]=temp;
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
    //算法4：
    public static int[] sort4(int[] arry){
    return null;
    }


}
