public class Solution {
    //solution1: bruth force: time complexity:  (2n - 1) * n = O(n ^ 2)
    //space complexity is O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        totalLength = 0;
        maxLeft = -1;
        for (int i = 0; i < s.length() * 2; i++) {
            int left = i / 2;
            int right = i / 2;
            if (i % 2 == 1)
                right++;
            getPalindrome(s, left, right);
        }
        if (totalLength > 0) 
            return s.substring(maxLeft, maxLeft + totalLength);
        return "";
    }
    private int totalLength;
    private int maxLeft;
    private void getPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int localLength = right - left - 1;
        if (localLength > totalLength) {
            totalLength = localLength;
            maxLeft = left + 1;
        }
    }
    //solution 2: dynamic programming solution: 
    //time complexity: O(n ^ 2)
    //space complexity: O(n ^ 2)
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0)
            return "";
        boolean[][] res = new boolean[s.length()][s.length()];
        int count = 0;
        int maxLeft = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || res[i + 1][j - 1])) {
                    res[i][j] = true;
                    if (j - i + 1 > count) {
                        count = j - i + 1;
                        maxLeft = i;
                    }
                }
            }
        }
        if (count > 0) {
            return s.substring(maxLeft, maxLeft + count);
        }
        else {
            return "";
        }
    }
}
