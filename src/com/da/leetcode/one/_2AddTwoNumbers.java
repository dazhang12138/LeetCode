package com.da.leetcode.one;

import com.da.leetcode.utils.ListNode;
import com.da.leetcode.utils.Print;

/**
 * @author Da
 * @date 2020/5/20 13:54
 */
public class _2AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l12;
        ListNode l13 = new ListNode(3);
        l12.next = l13;
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        l2.next = l22;
        ListNode l23 = new ListNode(4);
        l22.next = l23;
        Print.printObject(addTwoNumbers(l1,l2));
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表1 + 链表2
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = l1 == null ? new ListNode(0):l1;
        l2 = l2 == null ? new ListNode(0):l2;
        ListNode sum = new ListNode((l1.val + l2.val) % 10);
        int carry = (l1.val + l2.val) / 10;
        if(l1.next==null && l2.next==null && carry == 0){
            return sum;
        }
        l1 = l1.next == null ? new ListNode(0):l1.next;
        l2 = l2.next == null ? new ListNode(0):l2.next;
        l1.val += carry;
        sum.next = addTwoNumbers(l1, l2);
        return sum;
    }
}
