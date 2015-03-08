/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (n < 0)
            return res;
        if (n == 0) {
            res.add(null);
            return res;
        }
        res = generateHelper(1, n);
        return res;
    }
    private List<TreeNode> generateHelper(int left, int right) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = generateHelper(left, i - 1);
            List<TreeNode> rightList = generateHelper(i + 1, right);
            
            for (int k1 = 0; k1 < leftList.size(); k1++) {
                for (int k2 = 0; k2 < rightList.size(); k2++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(k1);
                    root.right = rightList.get(k2);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
