public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target)
                return true;
            if (A[mid] < A[right]) {
                if (target > A[mid] && target <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else if (A[mid] > A[right]) {
                if (target >= A[left] && target < A[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else {
                right--;
            }
        }
        return false;
    }
}
