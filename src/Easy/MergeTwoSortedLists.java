package Easy;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */


public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        //checking nulls
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }

        //setting head
        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }
        else if(l1.val >= l2.val){
            head = l2;
            l2 = l2.next;
        }

        //setting internal nodes
        ListNode body = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                body.next = l1;
                body = l1;
                l1 = l1.next;
            }
            else if(l1.val >= l2.val){
                body.next = l2;
                body = l2;
                l2 = l2.next;
            }
        }
        if(l2 == null){
            body.next = l1;
        }
        else{
            body.next = l2;
        }
        return head;
    }
}
