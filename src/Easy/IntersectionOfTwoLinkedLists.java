package Easy;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 Credits:
 Special thanks to @stellari for adding this problem and creating all test cases.
 */

public class IntersectionOfTwoLinkedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //find size of A and B
        int sizeA = getSize(headA), sizeB = getSize(headB);

        //traverse bigger linkedList till |A-B|
        ListNode big = (sizeA > sizeB) ? headA : headB;
        ListNode small = (sizeA <= sizeB) ? headA : headB;
        for(int i = 0; i < Math.abs(sizeA - sizeB); i++) {
            big = big.next;
        }

        //campare each node from that point
        while(big != null) {
            if(big == small) return big;
            big = big.next;
            small = small.next;
        }
        return null;
    }

    public static int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
