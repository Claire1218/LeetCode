public class Solution {
    public boolean isPalindrome(int x) {
        //time complexity: O(n), n is the number of digits of x
        //space complexity: O(1)
        if (x < 0)
            return false;
        int digits = 1;
        int num = x;
        while (num / 10 > 0) {
            digits *= 10;
            num /= 10;
        }
        num = x;
        while (digits > 0) {
            int left = num / digits;
            int right = num % 10;
            if (left != right)
                return false;
            num = (num % digits) / 10;
            digits /= 100;
        }
        return true;
        
    }
}
