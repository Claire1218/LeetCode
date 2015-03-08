public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0)
            return -1;
        if (num.length == 1)
            return 0;
        if (num[1] < num[0])
            return 0;
        if (num[num.length - 2] < num[num.length - 1])
            return num.length - 1;
        for (int i = 1; i < num.length - 1; i++) {
            if ((num[i] - num[i - 1]) * (num[i + 1] - num[i]) < 0)
                return i;
        }
        return -1;
    }
    public int findPeakElement2(int[] num) {
        if (num == null || num.length == 0)
            return -1;
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            int min = Math.min(num[left], num[right]);
            if (num[left] == min) {
                left++;
                while (left <= right && num[left] > num[left - 1]) {
                    left++;
                }
                if (left > right)
                    return right;
                else
                    return left - 1;
            }
            else {
                right--;
                while (left <= right && num[right] > num[right + 1]) {
                    right--;
                }
                if (right < left)
                    return left;
                else {
                    return right + 1;
                }
            }
        }
        return 0;
    }
}
