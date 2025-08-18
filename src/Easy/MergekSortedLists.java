/*

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> listInt = new ArrayList<>();
        ListNode head = new ListNode(0);
        for (int i = 0; i < lists.length; i++) {
            ListNode currNode = lists[i];
            while (currNode != null) {
                listInt.add(currNode.val);
                currNode = currNode.next;
            }
        }

        Collections.sort(listInt);
        ListNode currNode = head;
        for (int i = 0; i < listInt.size(); i++) {
            currNode.next = new ListNode(listInt.get(i));
            currNode = currNode.next;
        }
        return head.next;
    }
}
