package com.da.leetcode._01;

import com.da.leetcode.utils.Print;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Da
 * @date 2020/5/21 9:56
 */
public class _5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Print.printObject(longestPalindrome("babadada"));
//        Print.printObject(longestPalindrome("bb"));
//        Print.printObject(longestPalindrome("abacab"));
//        Print.printObject(longestPalindrome("ac"));
//        Print.printObject(longestPalindrome("a"));
//        Print.printObject(longestPalindrome("babad"));
//        Print.printObject(longestPalindrome("cbbd"));
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.equals("")){
            return "";
        }
        Map<String,String> hasMap = new HashMap<>();
        String maxStr = s.substring(0,1);
        for (int i = 0; i < s.length(); i++){
            //s字符串的当前第i个字符
            String strChari = s.substring(i,i+1);
            if(hasMap.containsKey(strChari)){
                continue;
            }
            hasMap.put(strChari,"");
            //以第i个字符分割s字符串返回结果包含第i个字符
            StringTokenizer stringTokenizer = new StringTokenizer(s,strChari,true);
            StringBuilder strBuilder = new StringBuilder();
            while (stringTokenizer.hasMoreTokens()){
                //当前分割后子串
                String item = stringTokenizer.nextToken();
                if(item.equals(strChari)){
                    //如果切割的是当前字符;判断是不是第一个，如果不是第一个则进行判断是否为回文串
                    if("".equals(strBuilder.toString())){
                        strBuilder.append(item);
                    }else{
                        strBuilder.append(item);
                        if(new StringBuffer(strBuilder).reverse().toString().equals(strBuilder.toString()) && strBuilder.length() > maxStr.length()){
                            maxStr = strBuilder.toString();
                        }
                    }
                }else {
                    if(!"".equals(strBuilder.toString())){
                        //如果切割的不是当前字符并且strBuilder有值则添加到strBuilder；
                        strBuilder.append(item);
                    }
                }
            }
        }
        return maxStr;
    }
}
