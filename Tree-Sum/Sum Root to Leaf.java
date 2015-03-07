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
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sumHelper(root, 0);
    
    }
    private int sumHelper(TreeNode node, int sum) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null) {
            return sum * 10 + node.val;
        }
        return sumHelper(node.left, sum * 10 + node.val) + sumHelper(node.right, sum * 10 + node.val);
    }
}
