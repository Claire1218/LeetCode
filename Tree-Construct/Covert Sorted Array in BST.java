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
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
            return null;
        return buildHelper(num, 0, num.length - 1);
    }
    private TreeNode buildHelper(int[] num, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildHelper(num, left, mid - 1);
        root.right = buildHelper(num, mid + 1, right);
        return root;
    }
}
