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
    public LinkedList<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null)
            return res;
            
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(root.val);
        res.add(cur);
        
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> newQueue = new LinkedList<TreeNode>();
            cur = new ArrayList<Integer>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    newQueue.offer(temp.left);
                    cur.add(temp.left.val);
                }
                if (temp.right != null) {
                    newQueue.offer(temp.right);
                    cur.add(temp.right.val);
                }
            }
            queue = newQueue;
            if (cur.size() > 0) {
                res.addFirst(cur);
            }
        }
        return res;
    }
}
