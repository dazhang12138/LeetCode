package com.da.leetcode._03;

import com.da.leetcode.utils.ListNode;
import com.da.leetcode.utils.Print;

import java.util.LinkedList;

/**
 * @author Da
 * @date 2020/6/10 13:41
 */
public class _24SwapNodesInPairs {
    public static void main(String[] args) {

        ListNode head4 = new ListNode(4);
        ListNode head3 = new ListNode(3,head4);
        ListNode head2 = new ListNode(2,head3);
        ListNode head = new ListNode(1,head2);
        Print.printObject("交换前链表",head);
        Print.printObject("交换后链表",swapPairs(head));
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head 链表
     * @return 交换后的链表
     */
    public static ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode end = head.next;

        pre.next = swapPairs(end.next);
        end.next = pre;

        return end;
    }

}
