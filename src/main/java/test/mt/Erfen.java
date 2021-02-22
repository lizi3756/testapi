package test.mt;

/**
 * @Author: lizi
 * @Date: 2020/9/28 3:43 下午
 */
public class Erfen {
    public static void main(String[] args) {
        //System.out.println(search(arr,100));
        int[] arr = {0,1,2,3,4,5,6,7,9};
        System.out.println(lose(arr));
    }
    public static int lose1(int[] arr){
        int left =0 ,right = arr.length-1;
        while (left <= right){
            int mid = (left+ right)/2;
            if(arr[mid] == mid){
                right = mid + 1;
            }else {
                left = mid - 1;
            }
        }
        return left;
    }
    public static int lose(int[] arr){
        int lose = -1;
        for(int i = 0 ; i<= arr.length; i++){
            if(arr[i]!= i){
                lose = i;
                break;
            }
        }
        return lose;
    }
    //寻找比目标字母大的最小的字母（找大值，返回左边界）
    public static char nextGreatestLetter(char[] letters, char target){
        int left =0 , right = letters.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(letters[mid] <= target){//中间值与target相等的时候，因为找的值是比target大的，所以继续往右边寻找
                left = mid +1 ;
            }else {
                right = mid -1;
            }
        }
        return left < letters.length ? letters[left] : letters[0];
    }
    //寻找比目标字母小的最大的字母（找小值，返回右边界）
    public static char nextLessestLetter(char[] letters, char target){
        int left =0 , right = letters.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(letters[mid] < target){
                left = mid +1 ;
            }else {//中间值与target相等的时候，因为找的值是比target小的，所以继续往左边寻找
                right = mid -1;
            }
        }
        return right >0 ? letters[right] : letters[0];
    }

    public static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int count = 0;
        while (start <= end) {
            count++;
            int middle = (start + end) / 2 ;
            if (key < arr[middle]) {
                end = middle - 1;
            } else if (key > arr[middle]) {
                start = middle + 1;
            } else {
                System.out.println("总共查找了："+count+"次，元素的下标为："+ middle);
                return middle;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arry,int target){
        int left=0,right=arry.length-1,count=0;
        while(left<=right){
            count++;
            int mid=(left+right)>>1;
            System.out.println("mid"+mid);
            if(arry[mid]==target){
                System.out.println("查询了"+count+"次");
                return mid;
            }else if(arry[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;

    }

    //开平方
    public static int sq(int x){
        long left = 1 ;
        long right = x / 2;
        while (left <= right){
            long mid = (left + right) / 2 ;
            if(mid * mid > x){
                right = mid -1;
            }else if(mid * mid < x){
                left = mid + 1;
            }else {
                return (int)mid;
            }
        }
        return (int)right;
    }

    //判断一个数是不是完全平方数
    public static boolean sq1(int x){
        int left = 1;
        int right = x / 2;
        while (left <= right){
            int mid = (left + right) / 2 ;
            if(mid * mid > x ){
                right = mid - 1;
            }else if(mid * mid < x){
                left = mid +1;
            }else {
                return true;
            }
        }
        return  false;
    }

    //排列硬币
    //总数和行数存在对应关系,(n+1)*n/2 = sum
    public static int arrangeCoins(int x){
        int left = 0,right = x;
        while (left <= right){
            long mid = (left + right) / 2;
            long cost = ((mid +1) * mid) / 2;
            if(x == cost){
                return (int) mid;
            }else if (x > cost){
                left = (int)mid + 1;
            }else {
                right = (int)mid - 1;
            }
        }
        return right;
    }
    public static int arrangeCoins1(int n) {
        int low = 0, high = n;
        while (low <= high) {
            long mid = (high + low) / 2 ;
            long cost = ((mid + 1) * mid) / 2;
            if (cost == n) {
                return (int)mid;
            } else if (cost > n) {
                high = (int)mid - 1;
            } else {
                low = (int)mid + 1;
            }
        }
        return high;
    }

}
