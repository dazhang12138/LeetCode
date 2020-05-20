package com.da.leetcode.utils;

/**
 * @author Da
 * @date 2020/5/20 13:55
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + (next != null ? " -> " + next.toString() : " ");
    }
}
