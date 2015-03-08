public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0)
            return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target- numbers[i])) {
                res[0] = map.get(target - numbers[i]);
                res[1] = i + 1;
                return res;
            }
            map.put(numbers[i], i + 1);
        }
        return res;
    }
}
