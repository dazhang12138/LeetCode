package com.da.leetcode._02;

import com.da.leetcode.utils.Print;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Da
 * @date 2020/6/8 11:19
 */
public class _20ValidParentheses {

    public static void main(String[] args) {
//        Print.printObject(isValid("()"));
//        Print.printObject(isValid("()[]{}"));
//        Print.printObject(isValid("(]"));
//        Print.printObject(isValid("([)]"));
//        Print.printObject(isValid("{[]}"));
        Print.printObject(isValid("]"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 只包括括号的字符串
     * @return 是否闭合
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(s.charAt(i));
            }else{
                char c2 = ' ';
                if(c == ')'){
                    c2 = '(';
                }else if(c == ']'){
                    c2 = '[';
                }else{
                    c2 = '{';
                }
                if(!stack.empty()){
                    Character pop = stack.pop();
                    if(pop != c2){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }else {
            return false;
        }
    }

}
