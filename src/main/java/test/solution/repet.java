package test.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: lizi
 * @Date: 2021/2/22 下午7:10
 */
public class repet {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4};
        System.out.println(containsDuplicate(nums));
        String s ="I'm a beautiful girl";
        System.out.println(reverseWords(s));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            /*if (set.contains(num)) {
                return true;
            }*/
            set.add(num);
        }
        return set.size()!= nums.length;
    }
    public static String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
