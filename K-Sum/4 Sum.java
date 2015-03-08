public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length < 4)
            return res;
        Arrays.sort(num);
        res = kSum(num, 4, num.length - 1, target);
        return res;
        
    }
    private List<List<Integer>> kSum(int[] num, int k, int index, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k == 2) {
            int left = 0;
            int right = index;
            while (left < right) {
                if (num[left] + num[right] == target) {
                    List<Integer> curList = new ArrayList<Integer>();
                    curList.add(num[left]);
                    curList.add(num[right]);
                    res.add(curList);
                    left++;
                    right--;
                    while (left < right && num[left] == num[left - 1])
                        left++;
                    while (left < right && num[right] == num[right + 1])
                        right--;
                }
                else if (num[left] + num[right] < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
            return res;
        }
        for (int i = index; i >= k - 1; i--) {
            if (i < index && num[i] == num[i + 1])
                continue;
            List<List<Integer>> curRes = kSum(num, k - 1, i - 1, target - num[i]);
            if (curRes != null && curRes.size() > 0) {
                for (List<Integer> curList: curRes) {
                    curList.add(num[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }
}
