package com.da.leetcode._02;

import com.da.leetcode.utils.Print;

import java.util.*;

/**
 * @author Da
 * @date 2020/6/4 13:41
 */
public class _184Sum {
    public static void main(String[] args) {
//        Print.printObject(fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
        Print.printObject(fourSum(new int[]{-1,-5,-5,-3,2,5,0,4},-7));
    }

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意：答案中不可以包含重复的四元组。
     *
     * 示例：给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 整数的数组
     * @param target 目标值
     * @return 满足条件且不重复的四元组
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> backLists = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();
        if(nums.length < 4){
            return backLists;
        }
        Arrays.sort(nums);

        for (int i = 0;i < nums.length-3;i++){
            for (int j = i+1;j < nums.length-2;j++){
                int a = i+2,b = nums.length-1;
                while (a < b){
                    if(a == j){
                        a++;
                        continue;
                    }
                    if(b == j){
                        b--;
                        continue;
                    }
                    int s = nums[i] + nums[j] + nums[a] + nums[b];
                    if(s < target){
                        a++;
                    }else if (s == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.sort((o1, o2) -> o1-o2);
                        hashSet.add(list);
                        a++;
                    }else {
                        b--;
                    }
                }
            }
        }
        backLists.addAll(hashSet);
        return backLists;
    }
}
