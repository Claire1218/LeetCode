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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = root;
        while (!stack.isEmpty() || pre != null) {
            if (pre != null) {
                stack.push(pre);
                pre = pre.left;
            }
            else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                pre = temp.right;
            }
        }
        return res;
    }
}
