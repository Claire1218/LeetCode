public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        for (int i = num.length - 1; i >= 2; i--) {
            if (i < num.length - 1 && num[i] == num[i + 1])
                continue;
            List<List<Integer>> twoRes = twoSum(num, i - 1, (-1) * num[i]);
            if (twoRes.size() > 0) {
                for (List<Integer> curList: twoRes) {
                    curList.add(num[i]);
                }
                res.addAll(twoRes);
            }
        }
        return res;
        
    }
    private List<List<Integer>> twoSum(int[] num, int end, int target) {
        List<List<Integer>> twoRes = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0)
            return twoRes;
        int left = 0;
        int right = end;
        while (left < right) {
            if (num[left] + num[right] == target) {
                List<Integer> curRes = new ArrayList<Integer>();
                curRes.add(num[left]);
                curRes.add(num[right]);
                twoRes.add(curRes);
                left++;
                right--;
                while (left < right && num[left] == num[left - 1])
                    left++;
                while (left < right && num[right] == num[right + 1])
                    right--;
            }
            else if (num[left] + num[right] < target)
                left++;
            else
                right--;
        }
        return twoRes;
    }
    
}
