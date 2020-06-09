package com.da.leetcode._03;

import com.da.leetcode.utils.ListNode;
import com.da.leetcode.utils.Print;

/**
 * @author Da
 * @date 2020/6/9 9:44
 */
public class _21MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l4;
        ListNode l11 = new ListNode(1);
        l11.next = l3;
        l3.next = l5;

        Print.printObject("l1链表",l1);
        Print.printObject("l11链表",l11);
        Print.printObject(mergeTwoLists(l1,l11));
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后链表
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode end = pre;
        while (l1 != null || l2 != null){
            if(l1 == null){
                end.next = l2;
                break;
            }
            if(l2 == null){
                end.next = l1;
                break;
            }
            if(l1.val <= l2.val){
                end.next = l1;
                end = end.next;
                l1 = l1.next;
            }else{
                end.next = l2;
                end = end.next;
                l2 = l2.next;
            }
        }
        return pre.next;
    }
}
