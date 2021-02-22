package test.mt;

/**
 * @Author: lizi
 * @Date: 2021/2/18 下午6:49
 */
public class huiwen2 {
    public static void main(String[] args) {
        //System.out.println(same(-232));
        System.out.println(noRepeat("abcdefgabcd"));
    }
    //判断一个整数是不是回文？
    public static  boolean same(int x){
        int sum =0, temp =x;
        while (temp!=0){
            sum = sum*10 + temp % 10;
            temp = temp/10;
        }
        return x==sum;
    }
    //转换成字符串在翻转，再对比（只能是正整数）
    public static  boolean same2(int x){
        StringBuilder str = new StringBuilder(String.valueOf(x));
        String x1 = str.reverse().toString();
        return Integer.parseInt(x1) == x;
    }
    //字符串为'abcdefgabcd'，返回第一个不重复的字符
    public static char noRepeat(String str){
        int index = -1;
        if(str.isEmpty() || str.length()<=0){
            index = -1;
        }
        //转换成字符串数组
        char[] chars = str.toCharArray();
        for( int i =0; i<chars.length;i++){
            if(str.indexOf(chars[i])== str.lastIndexOf(chars[i])){
                index = i;
                break;
            }
        }
        if(index ==-1){
            return ' ';
        }
        return chars[index];
    }
}
