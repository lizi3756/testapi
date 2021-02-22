package test.mt;

import java.util.MissingFormatArgumentException;

/**
 * @Author: lizi
 * @Date: 2020/9/30 2:40 下午
 * 二分法开平方
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }
    //完全平方数
    public static boolean sq(int num){
         int left = 1;
         int right = num/2;
         while(left < right){
             int mid = (left + right) /2 +1;
             if((double)mid * mid < num) left = mid ;
             else if((double)mid * mid > num) right = mid - 1;
             else return true;
         }
         return false;
    }
    public static  int mySqrt(int x){
        if(x == 0){
            return 0;
        }
        long left = 1;
        long right = x / 2;//一般x的平方根都小于等于它的一半
        while (left < right){
            long mid = ( right + left ) / 2 +1;
            if(mid * mid > x ){
                right = mid - 1;
            }else if(mid * mid < x ) {
                left = mid ;
            }else {
                return (int)mid;
            }
        }
        return (int)left;
    }
}
