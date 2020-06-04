package com.da.leetcode._02;

import com.da.leetcode.utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Da
 * @date 2020/6/4 10:23
 */
public class _17LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Print.printObject(letterCombinations("23"));

    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param digits 数字字符串
     * @return 对应字母映射
     */
    public static List<String> letterCombinations(String digits) {
        List<String> back = new ArrayList<>();
        for (int i = 0; i < digits.length();i++){
            back = stringCombinations(back,strs[Integer.valueOf(digits.substring(i,i+1))]);
        }
        return back;
    }
    private static final String[] strs = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private static List<String> stringCombinations(List<String> list,String s2){
        List<String> backList = new ArrayList<>();
        if(list.size() == 0){
            for (int i = 0; i < s2.length();i++){
                String s = s2.substring(i,i+1);
                backList.add(s);
            }
        }else{
            for (int i = 0; i < s2.length();i++){
                String s = s2.substring(i,i+1);
                list.stream().forEach(item -> {
                    backList.add(item+s);
                });
            }
        }
        return backList;
    }

}
