package com.da.leetcode.one;

import com.da.leetcode.utils.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Da
 * @date 2020/5/20 15:20
 */
public class _4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Print.printObject(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        Print.printObject(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        Print.printObject(findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
        Print.printObject(findMedianSortedArrays(new int[]{2},new int[]{}));
    }

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 则中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //i、j记录两个数组下标；len记录两个数组长度之和；a、b记录中间数（len奇数时a=b）
        int i = -1,j = -1,len = nums1.length + nums2.length, a = 0, b = 0;
        //lenk为循环次数。len奇数时循环(len+1)/2次，最后一次为中间数；len偶数时循环(len/2+1)次，倒数两次的和/2为中间数；
        int lenk = ((len%2 == 0) ? (len/2+1) : ((len+1)/2));
        for (int k = 0; k < lenk;k++){
            if(j == nums2.length-1){
                //数组2下标最大值时
                if(len%2 == 0 && k == lenk-1){
                    //偶数时b = 最后一次循环；a = 倒数第二次循环；
                    b = nums1[i+1];
                }else{
                    //奇数时a = b = 最后一次循环；
                    b = a = nums1[i+1];
                }
                i++;
            }else if(i == nums1.length-1 || nums1[i+1] > nums2[j+1]){
                //数组1下标最大值时 或者 当前坐标下数组1大于数组2
                if(len%2 == 0 && k == lenk-1){
                    b = nums2[j+1];
                }else{
                    b = a = nums2[j+1];
                }
                j++;
            }else{
                //当前坐标下数组1小于数组2
                if(len%2 == 0 && k == lenk-1){
                    b = nums1[i+1];
                }else{
                    b = a = nums1[i+1];
                }
                i++;
            }
        }
        return (a + b) / 2.0;
    }
}

