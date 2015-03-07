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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur = 1;
        int next = 0;
        int level = 0;
        
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            cur--;
            if (res.size() <= level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
                next++;
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                next++;
            }
            if (cur == 0) {
                cur = next;
                next = 0;
                level++;
            }
            
        }
        return res;
        
    }
    
}
