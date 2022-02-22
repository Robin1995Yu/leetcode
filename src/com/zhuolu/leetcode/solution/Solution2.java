package com.zhuolu.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author zhuolu
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0;
        ListNode head = new ListNode();
        ListNode curr = head;
        while (l1 != null  || l2 != null) {
            i = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + i;
            curr.next = new ListNode(i % 10);
            i = i / 10;
            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (i > 0) {
            curr.next = new ListNode(i);
        }
        return head.next;
    }

    class ListNode {
        int val;

        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
