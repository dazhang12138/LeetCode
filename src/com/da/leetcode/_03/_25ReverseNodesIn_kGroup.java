package com.da.leetcode._03;

import com.da.leetcode.utils.ListNode;
import com.da.leetcode.utils.Print;

import java.util.LinkedList;

/**
 * @author Da
 * @date 2020/6/11 9:44
 */
public class _25ReverseNodesIn_kGroup {

    public static void main(String[] args) {
        ListNode head5 = new ListNode(5);
        ListNode head4 = new ListNode(4,head5);
        ListNode head3 = new ListNode(3,head4);
        ListNode head2 = new ListNode(2,head3);
        ListNode head = new ListNode(1,head2);
        Print.printObject("交换前链表",head);
        Print.printObject("交换后链表",reverseKGroup(head,3));
    }

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 示例：
     * 给你这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 说明：
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head 链表
     * @param k 每组节点个数
     * @return 翻转后链表
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        if(head == null){
            return null;
        }

        ListNode pre = head;
        int i = 1;
        while (head != null && i <= k){
            head = head.next;
            i++;
        }
        if (i-1 != k){
            return pre;
        }
        ListNode end = head;

        end = reverseKGroup(end,k);
        pre = reverse(pre,k);
        ListNode back = pre;
        while (true){
            if(pre.next == null){
                break;
            }
            pre = pre.next;
        }
        pre.next = end;

        return back;
    }

    private static ListNode reverse(ListNode head, int n){
        LinkedList<ListNode> listNodes = new LinkedList<>();
        while (head != null && n > 0){
            listNodes.addFirst(head);
            head = head.next;
            n--;
        }
        ListNode back = new ListNode(0);
        head = back;
        while (!listNodes.isEmpty()){
            ListNode listNode = listNodes.pollFirst();
            listNode.next = null;
            back.next = listNode;
            back = back.next;
        }
        return head.next;
    }

}
