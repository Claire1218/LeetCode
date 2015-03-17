public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;
        boolean[][] checker = palinChecker(s);
        int[] cuts = new int[s.length() + 1];
        cuts[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            cuts[i + 1] = i + 1;
            for (int j = 0; j <= i; j++) {
                if (checker[j][i]) {
                    cuts[i + 1] = Math.min(cuts[i + 1], cuts[j] + 1);
                }
            }
        }
        return cuts[s.length()] - 1;
    }
    private boolean[][] palinChecker(String s) {
        boolean[][] checker = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || checker[i + 1][j - 1]))
                    checker[i][j] = true;
            }
        }
        return checker;
    }
}
