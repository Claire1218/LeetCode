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
    //solution1: recursive solution
    public int maxDepth_recursive(TreeNode root) {
        if (root == null)
            return 0;
        int left = depthHelper(root.left);
        int right = depthHelper(root.right);
        return Math.max(left, right) + 1;
    }
    
    //solution2: non-recursive solution
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur = 1;
        int next = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            cur--;
            
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
        return level;
        
    }
}
