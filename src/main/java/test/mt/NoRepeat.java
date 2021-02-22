package test.mt;

import sun.plugin2.message.GetAppletMessage;

/**
 * @Author: lizi
 * @Date: 2020/9/28 5:57 下午
 * 返回字符串中第一个不重复的字符串,从左到右查，从右到左查，如果索引值相等，则该元素只出现过一次，则退出循环
 * 如字符串为'abcdefgabcd'
 * indexOf 是查某个指定的字符串在字符串首次出现的位置（索引值）（从左往右）
 * lastIndexOf 是查某个指定的字符串在字符串最后一次出现的位置（索引值）（从右往左）
 */
//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
public class NoRepeat {
    public static void main(String[] args) {
        char repeat = getNoRepeat("abcdefgabcd");
        System.out.println(repeat);
    }
    public static char getNoRepeat(String str){
        String s=str.trim();
        int index = -1;
        for(int i = 0;i < s.length();i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                index = i;
                break;
            }
        }
        if(index ==-1){
            return ' ';
        }
        else {
            return s.charAt(index);
        }
    }

}
