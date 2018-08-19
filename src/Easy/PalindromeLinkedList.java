package Easy;

/**
 * Given a singly linked list, determine if it is a palindrome.

 Example 1:

 Input: 1->2
 Output: false
 Example 2:

 Input: 1->2->2->1
 Output: true
 Follow up:
 Could you do it in O(n) time and O(1) space?
 */

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //O(n)
    public boolean isPalindrome(ListNode head) {
        ListNode input = head;
        ListNode mid = getMiddleNode(input);
        ListNode second = reverseSecondHalf(mid);
        //compare first and second half : O(n/2)
        while (second != null) {
            if (input.val != second.val) return false;
            input = input.next;
            second = second.next;
        }
        return true;
    }

    //find size/2 : O(n/2)
    public static ListNode getMiddleNode(ListNode input) {
        ListNode slow = input, fast = input;
        while (fast != null) {
            slow = slow.next;
            fast = (fast.next != null) ? fast.next.next : null;
            if (fast != null && fast.next == null) {
                slow = slow.next;
                break;
            }
        }
        return slow;
    }

    //reverse second half : O(n/2)
    public static ListNode reverseSecondHalf(ListNode cur) {
        ListNode prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
