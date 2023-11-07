package solution.datastructs;

import java.lang.reflect.Member;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        if (next == null) {
            return String.valueOf(val);
        }
        return val + "," + next;
    }
}