/*

Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.

 

Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    double minDiff = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        find(root, target);
        return ans;
    }

    public void find(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        double diff = Math.abs(root.val - target);
        if (diff < this.minDiff) {
            this.minDiff = diff;
            this.ans = root.val;
        }
        if (diff == this.minDiff) {
            this.ans = Math.min(this.ans, root.val);
        }
        find(root.left, target);
        find(root.right, target);
    }
}
