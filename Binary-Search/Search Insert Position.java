public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return mid;
            }
            else if (A[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
