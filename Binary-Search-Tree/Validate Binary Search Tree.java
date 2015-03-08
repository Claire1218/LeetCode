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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        // return validateHelper(root); //solution1
        return validateHelper2(root, null, null);
        
    }
    //solution 1: inorder traversal
    private TreeNode pre = null;
    private boolean validateHelper(TreeNode node) {
        if (node == null)
            return true;
        boolean left = validateHelper(node.left);
        if (pre != null && pre.val >= node.val)
            return false;
        pre = node;
        return left && validateHelper(node.right);
    }
    //solution2: min and max
    private boolean validateHelper2(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;
        if (min != null && node.val <= min)
            return false;
        if (max != null && node.val >= max)
            return false;
        return validateHelper2(node.left, min, node.val) && validateHelper2(node.right, node.val, max);
    }
}
