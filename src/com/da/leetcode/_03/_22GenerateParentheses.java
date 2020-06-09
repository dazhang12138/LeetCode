package com.da.leetcode._03;

import com.da.leetcode.utils.Print;

import java.util.*;

/**
 * @author Da
 * @date 2020/6/9 10:31
 */
public class _22GenerateParentheses {
    public static void main(String[] args) {
        Print.printObject("生成4对括号的所有有效组合",generateParenthesis2(3));
    }

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 示例：
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 生成括号对数
     * @return 所有有效的括号组合
     */
    public static List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        set.add("()");
        integerSetMap.put(1,set);
        generate(n);
        Set<String> strings = integerSetMap.get(n);
        List<String> list = new ArrayList<>();
        list.addAll(strings);
        return list;
    }

    private static Map<Integer,Set<String>> integerSetMap = new HashMap<>();
    private static void generate(int n){
        Set<String> set = new HashSet<>();
        if(n == 1){
            return;
        }
        for (int i = 1; i < n; i++){
            if(!integerSetMap.containsKey(i)){
                generate(i);
            }
            if(!integerSetMap.containsKey(n-i)){
                generate(n-i);
            }
            Set<String> isets = integerSetMap.get(i);
            Set<String> nisets = integerSetMap.get(n-i);
            isets.stream().forEach(item -> {
                nisets.stream().forEach(nitem -> {
                    set.add(item + nitem);
                    set.add(nitem + item);
                });
            });
        }
        if(!integerSetMap.containsKey(n-1)){
            generate(n-1);
        }
        Set<String> strings = integerSetMap.get(n - 1);
        strings.stream().forEach(item -> {
            set.add("(" +  item + ")");
        });
        integerSetMap.put(n,set);
    }


    /**
     * 深度优先树回溯解法
     * @param n 生成括号对数
     * @return 所有有效的括号组合
     */
    public static List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        generate2(n,n,"",list);
        return list;
    }


    private static void generate2(int left,int right,String present,List<String> list){
        if(left == 0 && right == 0){
            list.add(present);
        }
        if(left > right){
            return;
        }
        if(left > 0) {
            generate2(left-1, right, present+"(", list);
        }
        if(right > 0){
            generate2(left,right-1,present+")",list);
        }
    }

}
