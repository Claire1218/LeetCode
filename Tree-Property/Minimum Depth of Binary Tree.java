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
    public int minDepth(TreeNode root) {
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
            if (temp.left == null && temp.right == null) {
                return level + 1;
            }
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
        return -1;
    }
    
    //solution2: recursive solution
    private int minDepth_recursive(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth_recursive(root.right) + 1;
        if (root.right == null)
            return minDepth_recursive(root.left) + 1;
        return Math.min(minDepth_recursive(root.left), minDepth_recursive(root.right)) + 1;
    }
}
