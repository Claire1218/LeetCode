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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
    private TreeNode buildHelper(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR, HashMap<Integer, Integer> map) {
        if (preL > preR || inL > inR)
            return null;
        int val = preorder[preL];
        int index = map.get(val);
        TreeNode node = new TreeNode(val);
        node.left = buildHelper(preorder, inorder, preL + 1, preL + (index - inL), inL, index - 1, map);
        node.right = buildHelper(preorder, inorder, preL + (index - inL) + 1, preR, index + 1, inR, map);
        return node;
    }
}
