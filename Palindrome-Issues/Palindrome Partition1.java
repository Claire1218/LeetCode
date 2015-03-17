public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return res;
        partitionHelper(s, 0, new ArrayList<String>(), res);
        return res;
        
    }
    private void partitionHelper(String s, int index, List<String> cur, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isValid(substring)) {
                cur.add(substring);
                partitionHelper(s, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
