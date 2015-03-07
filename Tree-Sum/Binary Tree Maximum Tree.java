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
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        maxSumHelper(root);
        return sum;
    }
    private int sum = Integer.MIN_VALUE;
    private int maxSumHelper(TreeNode node) {
        if (node == null)
            return 0;
        int left = maxSumHelper(node.left);
        int right = maxSumHelper(node.right);
        int curSum = Math.max(left, 0) + Math.max(right, 0) + node.val;
        sum = Math.max(curSum, sum);
        return Math.max(Math.max(left, right), 0) + node.val;
    }
    
    
}
