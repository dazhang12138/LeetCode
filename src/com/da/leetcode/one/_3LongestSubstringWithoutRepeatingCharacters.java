package com.da.leetcode.one;

import com.da.leetcode.utils.Print;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Da
 * @date 2020/5/20 14:35
 */
public class _3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Print.printObject(lengthOfLongestSubstring("abba"));
        Print.printObject(lengthOfLongestSubstring(""));
        Print.printObject(lengthOfLongestSubstring(" "));
        Print.printObject(lengthOfLongestSubstring("asdfghjkl"));
        Print.printObject(lengthOfLongestSubstring("abcabcbb"));
        Print.printObject(lengthOfLongestSubstring("bbbbb"));
        Print.printObject(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @return 无重复字符长度
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int i = 0, max = 0;
        for (int c = 0; c < chars.length; c++){
            if(map.containsKey(chars[c])){
                i = (map.get(chars[c])+1) > i ? map.get(chars[c])+1 : i;
            }
            max = (c-i+1) > max ? c-i+1 : max;
            map.put(chars[c],c);
        }
        return max;
    }

}
