public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (A == null || A.length == 0)
            return res;
        int left = 0;
        int right = A.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            if (A[mid] == target) {
                break;
            }
            else if (A[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (A[mid] != target)
            return res;
        int newLeft = mid;
        int newRight = A.length - 1;
        while (newLeft <= newRight) {
            int newMid = (newLeft + newRight) / 2;
            if (A[newMid] == target) {
                newLeft = newMid + 1;
            }
            else {
                newRight = newMid - 1;
            }
        }
        res[1] = newRight;
        
        newLeft = 0;
        newRight = mid;
        while (newLeft <= newRight) {
            int newMid = (newLeft + newRight) / 2;
            if (A[newMid] == target) {
                newRight = newMid - 1;
            }
            else {
                newLeft = newMid + 1;
            }
        }
        res[0] = newLeft;
        return res;
        
    }
}
