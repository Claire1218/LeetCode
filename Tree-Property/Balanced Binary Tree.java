/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int height = getHeight(root);
        if (height == -1)
            return false;
        return true;
    }
    private int getHeight(TreeNode node) {
        if (node == null)   
            return 0;
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1)
            return -1;
        int diff = leftHeight - rightHeight;
        if (Math.abs(diff) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
