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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return symmetricHelper(root.left, root.right);
    }
    private boolean symmetricHelper(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null)
            return node1 == node2;
        return node1.val == node2.val && symmetricHelper(node1.left, node2.right) && symmetricHelper(node1.right, node2.left);
    }
}
