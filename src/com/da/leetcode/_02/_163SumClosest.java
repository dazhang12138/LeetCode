package com.da.leetcode._02;

import com.da.leetcode.utils.Print;

import java.util.Arrays;

/**
 * @author Da
 * @date 2020/6/4 9:38
 */
public class _163SumClosest {
    public static void main(String[] args) {
        Print.printObject(threeSumClosest(new int[]{1,1,-1,-1,3},-1));
    }

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 示例：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *
     * 提示：
     * 3 <= nums.length <= 10^3
     * -10^3 <= nums[i] <= 10^3
     * -10^4 <= target <= 10^4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 整数的数组
     * @param target 目标值
     * @return 最接近的三数之和
     */
    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE-abs(target);
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            int let = i+1, hig = nums.length-1;
            while (let < hig){
                int s = nums[i] + nums[let] + nums[hig];
                if(s < target){
                    let++;
                }else{
                    hig--;
                }
                min = abs(min-target) < abs(s-target) ? min : s;
            }
        }
        return min;
    }
    private static int abs(int a) {
        return (a < 0) ? -a : a;
    }
}
