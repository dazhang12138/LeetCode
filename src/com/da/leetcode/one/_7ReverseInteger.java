package com.da.leetcode.one;

import com.da.leetcode.utils.Print;

/**
 * @author Da
 * @date 2020/5/25 10:01
 */
public class _7ReverseInteger {
    public static void main(String[] args) {
//        Print.printObject(reverse(123));
        Print.printObject(reverse(-123));
//        Print.printObject(reverse(120));
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * @param x 有符号整数
     * @return 翻转后有符号整数
     */
    public static int reverse(int x) {
        try {
            boolean flag = (x < 0) ? false : true;
            x = flag ? x : -x;
            String s = String.valueOf(x);
            char[] cs = new char[s.length()];
            int i = 0;
            while (i < (s.length()+1)/2){
                cs[i] = s.charAt(s.length()-i-1);
                cs[s.length()-i-1] = s.charAt(i);
                i++;
            }
            Integer back = new Integer(String.valueOf(cs));
            return flag ? back : -back;
        }catch (Exception e){
            return 0;
        }
    }
}
