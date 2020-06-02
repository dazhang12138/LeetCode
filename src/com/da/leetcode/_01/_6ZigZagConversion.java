package com.da.leetcode._01;

import com.da.leetcode.utils.Print;

/**
 * @author Da
 * @date 2020/5/25 9:12
 */
public class _6ZigZagConversion {
    public static void main(String[] args) {
        Print.printObject(convert("LEETCODEISHIRING",3));
        Print.printObject(convert("LEETCODEISHIRING",4));
        Print.printObject(convert("A",2));
    }

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     *
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @param numRows 行数
     * @return z字形变换后字符串
     */
    public static String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        StringBuilder stringBuilder[] = new StringBuilder[numRows];
        //false为倒序插入，true为正序插入，先正序后倒序如此循环
        boolean flag = true;
        int j = 0;
        for (int i = 0; i < s.length();){
            j = flag ? 0 : numRows-1;
            while ((flag ? (j < numRows-1) : (j > 0)) && i < s.length()){
                if(stringBuilder[j] == null){
                    stringBuilder[j] = new StringBuilder();
                }
                stringBuilder[j].append(s.charAt(i));
                i++;
                j = flag ? j+1 : j-1;
            }
            flag = !flag;
        }
        StringBuilder stringBuilders = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            if(stringBuilder[i] != null){
                stringBuilders.append(stringBuilder[i]);
            }
        }
        return stringBuilders.toString();
    }
}
