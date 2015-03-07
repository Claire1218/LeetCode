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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(root.val);
        res.add(cur);
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int level = 0;
        while (!stack.isEmpty()) {
            Stack<TreeNode> newStack = new Stack<TreeNode>();
            cur = new ArrayList<Integer>();
            while(!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                if (level % 2 == 0) {
                    if (temp.right != null) {
                        newStack.push(temp.right);
                        cur.add(temp.right.val);
                    }
                    if (temp.left != null) {
                        newStack.push(temp.left);
                        cur.add(temp.left.val);
                    }
                }
                else {
                    if (temp.left != null) {
                        newStack.push(temp.left);
                        cur.add(temp.left.val);
                    }
                    if (temp.right != null) {
                        newStack.push(temp.right);
                        cur.add(temp.right.val);
                    }
                    
                }
            }
            level++;
            stack = newStack;
            if (cur.size() > 0)
                res.add(cur);
        }
        return res;
    }
}
