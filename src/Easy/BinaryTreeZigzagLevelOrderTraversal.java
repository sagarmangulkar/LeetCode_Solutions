/*

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

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
    public void helper(TreeNode node, List<List<Integer>> res, int level, boolean flag) {
        if (node == null) return;
        if (level == res.size()) {
            res.add(new ArrayList<Integer>());
        }
        if (flag) {
            res.get(level).add(node.val);
        } else {
            res.get(level).add(0, node.val);
        }
        flag = (flag) ? false : true;
        helper(node.left, res, level+1, flag);
        helper(node.right, res, level+1, flag);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;
        helper(root, res, 0, flag);
        return res;
    }
}
