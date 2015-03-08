public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3)
            return Integer.MIN_VALUE;
        Arrays.sort(num);
        int closest = num[0] + num[1] + num[2] - target;
        for (int i = num.length - 1; i >= 3; i--) {
            int curClosest = twoSumClosest(num, i - 1, target - num[i]);
            if (Math.abs(curClosest) < Math.abs(closest))
                closest = curClosest;
        }
        return closest + target;
    }
    
    private int twoSumClosest(int[] num, int end, int target) {
        if (num == null || num.length < 2)
            return Integer.MIN_VALUE;
        int closest = num[0] + num[1] - target;
        int left = 0;
        int right = end;
        while (left < right) {
            if (num[left] + num[right] == target)
                return 0;
            int diff = num[left] + num[right] - target;
            if (Math.abs(diff) < Math.abs(closest))
                closest = diff;
            if (num[left] + num[right] < target) 
                left++;
            else
                right--;
        }
        return closest;
    }
}
