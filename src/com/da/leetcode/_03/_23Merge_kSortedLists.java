package com.da.leetcode._03;

import com.da.leetcode.utils.ListNode;
import com.da.leetcode.utils.Print;

import java.util.*;

/**
 * @author Da
 * @date 2020/6/9 15:01
 */
public class _23Merge_kSortedLists {
    public static void main(String[] args) {
        ListNode l123 = new ListNode(5);
        ListNode l12 = new ListNode(4,l123);
        ListNode l1 = new ListNode(1,l12);
        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3,l23);
        ListNode l2 = new ListNode(1,l22);
        ListNode l32 = new ListNode(6);
        ListNode l3 = new ListNode(2,l32);
        ListNode[] list = new ListNode[]{l1,l2,l3};
        Print.printObject("链表集合",list);
        Print.printObject("合并后的排序链表",mergeKLists(list));
    }

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * 示例:
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param lists 有序链表集合
     * @return 合并后的排序链表
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> priorityQueue = new PriorityQueue<ListNode>((o1, o2) -> o1.val-o2.val);
        for (int i = 0; i < lists.length; i++){
            while (lists[i]!=null){
                priorityQueue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode back = new ListNode(0);
        ListNode head = back;
        while (priorityQueue.peek() != null){
            ListNode poll = priorityQueue.poll();
            back.next = poll;
            back = back.next;
        }
        back.next = null;
        return head.next;
    }

}
