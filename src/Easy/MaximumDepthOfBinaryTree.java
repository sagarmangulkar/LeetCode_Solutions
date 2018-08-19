package Easy;

/**
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 Note: A leaf is a node with no children.

 Example:

 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 return its depth = 3.
 */

public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        int res = calculateHeight(root, 0);
        return res;
    }

    private int calculateHeight(TreeNode root, int height) {
        if(root == null) {
            return height;
        }
        int left = calculateHeight(root.left, height+1);
        int right = calculateHeight(root.right, height+1);
        return Math.max(left, right);
    }
}
