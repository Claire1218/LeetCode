public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0)
            return -1;
        int left = 0;
        int right = num.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num[mid] < num[right]) {
                min = Math.min(min, num[mid]);
                right = mid - 1;
            }
            else {
                min = Math.min(min, num[left]);
                left = mid + 1;
            }
        }
        return min;
    }
}
