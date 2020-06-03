package com.da.leetcode._02;

import com.da.leetcode.utils.Print;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Da
 * @date 2020/6/3 10:05
 */
public class _14LongestCommonPrefix {
    public static void main(String[] args) {
        Print.printObject(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        Print.printObject(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     *
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:所有输入只包含小写字母 a-z 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs 字符串数组
     * @return 最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        char[] chars = new char[strs[0].length()];
        for (int i = 0; i < strs[0].length(); i++){
            chars[i] = strs[0].charAt(i);
        }
        for (int i = 1; i < strs.length; i++){
            for (int j = 0; j < strs[i].length() && j < chars.length; j++){
                if(strs[i].charAt(j) != chars[j]){
                    chars[j] = ';';
                    break;
                }
            }
            if(chars.length == 0 || chars[0] == ';'){
                return "";
            }
            if(chars.length > strs[i].length()){
                chars[strs[i].length()] = ';';
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length && chars[i] != ';'; i ++){
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
