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
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode[] mistakes = new TreeNode[2];
        recoverHelper(root, mistakes);
        if (mistakes[0] != null && mistakes[1] != null) {
            int temp = mistakes[0].val;
            mistakes[0].val = mistakes[1].val;
            mistakes[1].val = temp;
        }
    }
    private TreeNode pre = null;
    private void recoverHelper(TreeNode node, TreeNode[] mistakes) {
        if (node == null)
            return;
        recoverHelper(node.left, mistakes);
        if (pre != null && pre.val > node.val) {
            if (mistakes[0] == null && mistakes[1] == null) {
                mistakes[0] = pre;
                mistakes[1] = node;
            }
            else {
                mistakes[1] = node;
            }
        }
        pre = node;
        recoverHelper(node.right, mistakes);
    }
}
