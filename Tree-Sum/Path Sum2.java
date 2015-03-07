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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(root.val);
        pathSumHelper(root, sum - root.val, cur, res);
        return res;
    }
    private void pathSumHelper(TreeNode node, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (node == null)
            return;
        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        if (node.left != null) {
            cur.add(node.left.val);
            pathSumHelper(node.left, sum - node.left.val, cur, res);
            cur.remove(cur.size() - 1);
        }
        if (node.right != null) {
            cur.add(node.right.val);
            pathSumHelper(node.right, sum - node.right.val, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
