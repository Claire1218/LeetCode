public class Solution {
    //time complexity: O(n)
    // space complexity: O(1)
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isValid(s.charAt(left)))
                left++;
            while (left < right && !isValid(s.charAt(right)))
                right--;
            if (!isSame(s.charAt(left), s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
        
    }
    private boolean isValid(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')
            return true;
        return false;
    }
    private boolean isSame(char c1, char c2) {
        if (c1 >= 'A' && c1 <= 'Z') 
            c1 = (char) (c1 - 'A' + 'a');
        if (c2 >= 'A' && c2 <= 'Z')
            c2 = (char) (c2 - 'A' + 'a');
        return c1 == c2 ? true : false;
    }
}
