package com.da.leetcode._02;

import com.da.leetcode.utils.ListNode;
import com.da.leetcode.utils.Print;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Da
 * @date 2020/6/5 15:00
 */
public class _19RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        Print.printObject(l1);
        Print.printObject(removeNthFromEnd(l1,2));
        Print.printObject(l1);
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：给定的 n 保证是有效的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head 头链表
     * @param n 节点
     * @return 删除倒数第n个节点后的头链表
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode start = head;
        int length = 1;
        while (head.next != null){
            head = head.next;
            length++;
        }
        if (n == length){
            start = start.next;
            return start;
        }
        length -= n+1;
        while (length > 0){
            length--;
            pre = pre.next;
        }
        pre.next = pre.next != null ? pre.next.next : null;
        return start;
    }

}
