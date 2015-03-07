/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode runner = head;
        int length = 0;
        while (runner != null) {
            length++;
            runner = runner.next;
        }
        cur = head;
        return buildHelper(0, length - 1);
        
    }
    private TreeNode buildHelper(int left, int right) {
        if (cur == null)
            return null;
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode leftNode = buildHelper(left, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        root.left = leftNode;
        root.right = buildHelper(mid + 1, right);
        return root;
    }
}
