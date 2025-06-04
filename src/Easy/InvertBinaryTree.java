package Easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.

 Example:

 Input:

     4
   /   \
  2     7
 / \   / \
 1   3 6   9
 Output:

     4
   /   \
  7     2
 / \   / \
 9   6 3   1
 Trivia:
 This problem was inspired by this original tweet by Max Howell:

 Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */

public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            curr.left = right;
            curr.right = left;
            if(left != null) {
                queue.add(left);
            }
            if(right != null) {
                queue.add(right);
            }
        }
        return root;
    }
}


//DFS

class Solution {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
    }
}
