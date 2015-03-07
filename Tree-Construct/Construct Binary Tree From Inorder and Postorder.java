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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }
    private TreeNode buildHelper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR, HashMap<Integer, Integer> map) {
        if (inL > inR || postL > postR)
            return null;
        int val = postorder[postR];
        int index = map.get(val);
        TreeNode cur = new TreeNode(val);
        cur.left = buildHelper(inorder, postorder, inL, index - 1, postL, postR - (inR - index) - 1, map);
        cur.right = buildHelper(inorder, postorder, index + 1, inR, postR - (inR - index), postR - 1, map);
        return cur;
    }
    
}
