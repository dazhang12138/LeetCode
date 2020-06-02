package com.da.leetcode._01;

import com.da.leetcode.utils.Print;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Da
 * @date 2020/5/28 9:48
 */
public class _10RegularExpressionMatching {
    public static void main(String[] args) {
//        Print.printObject(isMatch("aa","a"));
//        Print.printObject(isMatch("aa","a*"));
//        Print.printObject(isMatch("ab",".*"));
//        Print.printObject(isMatch("aab","c*a*b"));
//        Print.printObject(isMatch("mississippi","mis*is*p*."));
        Print.printObject(isMatch("a","ab*a"));
    }

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * 说明:
     *
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 示例 1:
     *
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     *
     * 示例 2:
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     *
     * 示例 3:
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     *
     * 示例 4:
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     *
     * 示例 5:
     * 输入:
     * s = "mississippi"
     * p = "mis*is*p*."
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * @param s 字符串
     * @param p 字符规律
     * @return 是否匹配规律
     */
    public static boolean isMatch(String s, String p) {

        Queue<String> queue = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < p.length() ;i++){
            if(p.charAt(i) == 42){
                String sub1 = p.substring(j,i+1);
                int k = i-j+1;
                if(k == 1){
                    return false;
                }else if(k == 2){
                    queue.add(sub1);
                }else{
                    queue.add(sub1.substring(0,k-2));
                    queue.add(sub1.substring(k-2,k));
                }
                j = i+1;
            }
        }
        if(j < p.length()){
            queue.add(p.substring(j));
        }
        j = 0;
        while (queue.peek() != null){
            String poll = queue.poll();
            if(poll.charAt(poll.length()-1) == 42){
                if(".*".equals(poll)){
                    if(queue.peek() != null){
                        String peek = queue.peek();
                        for (; j < s.length(); j++){
                            if(peek.charAt(0) != s.charAt(j)){
                                break;
                            }
                        }
                    }else{
                        return true;
                    }
                }else{
                    for (; j < s.length(); j++){
                        if(poll.charAt(0) != s.charAt(j)){
                            break;
                        }
                    }
                }
            }else{
                for (int i = 0; i < poll.length() && (j+i) < s.length(); i++){
                    if(poll.charAt(i) != 46){
                        if(s.charAt(j+i) != poll.charAt(i)){
                            return false;
                        }
                    }
                }
                j += poll.length();
            }
            if(j == s.length()){
                break;
            }
        }

        if(j == s.length() && queue.peek() == null){
            return true;
        }else{
            return false;
        }
    }
}
