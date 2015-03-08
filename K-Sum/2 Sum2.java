
public class TwoSum2 {
	
	//Given an array of integers that is already sorted in ascending order, 
	//find two numbers such that they add up to a specific target number.
	
	public int[] twoSum2(int[] arr, int target) {
		if (arr == null || arr.length < 2)
			return new int[2];
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			if (arr[left] + arr[right] == target) {
				return new int[]{left + 1, right + 1};
			}
			else if (arr[left] + arr[right] < target) {
				left++;
			}
			else 
				right--;
		}
		return new int[2];
	}
	

}
