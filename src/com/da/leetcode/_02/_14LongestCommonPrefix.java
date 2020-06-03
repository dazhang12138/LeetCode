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
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < strs[0].length(); i++){
            queue.add(strs[0].charAt(i));
        }
        for (int i = 1; i < strs.length; i++){
            Queue<Character> queue2 = new ArrayDeque<>();
            int j = 0;
            while (queue.peek() != null && j < strs[i].length()){
                if(queue.poll() == strs[i].charAt(j)){
                    queue2.add(strs[i].charAt(j));
                }else {
                    break;
                }
                j++;
            }
            if(queue2.isEmpty()){
                return "";
            }
            queue = queue2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (queue.peek() != null){
            stringBuilder.append(queue.poll());
        }
        return stringBuilder.toString();
    }
}
