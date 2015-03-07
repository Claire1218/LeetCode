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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        TreeNode pre = null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                else if (cur.right != null) {
                    stack.push(cur.right);
                }
                else {
                    TreeNode temp = stack.pop();
                    res.add(temp.val);
                }
            }
            else if (cur.left == pre) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                else {
                    TreeNode temp = stack.pop();
                    res.add(temp.val);
                }
            }
            else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
            }
            pre = cur;
        }
        return res;
    }
}
