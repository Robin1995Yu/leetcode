package solution;

import solution.datastructs.ListNode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result;
        if (list1.val > list2.val) {
            result = list2;
            list2 = list2.next;
        } else {
            result = list1;
            list1 = list1.next;
        }
        ListNode currNode = result;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                currNode.next = list2;
                break;
            }
            if (list2 == null) {
                currNode.next = list1;
                break;
            }
            if (list1.val >= list2.val) {
                currNode.next = list2;
                list2 = list2.next;
            } else {
                currNode.next = list1;
                list1 = list1.next;
            }
            currNode = currNode.next;
        }
        return result;
    }
}
