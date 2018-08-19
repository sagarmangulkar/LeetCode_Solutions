package Easy;

/**
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while(slow != fast) {
            if(slow == null || fast == null) return false;
            slow = slow.next;
            fast = (fast.next != null) ? fast.next.next : null;
        }
        return true;
    }
}
