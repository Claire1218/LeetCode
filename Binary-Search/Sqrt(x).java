public class Solution {
    public int sqrt(int x) {
        if (x < 0)
            return 0;
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return (int) right;
        
    }
}
