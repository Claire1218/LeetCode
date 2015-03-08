public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target) {
                row++;
            }
            else {
                col--;
            }
        }
        return false;
    }
    
    //time complexity: O(log m + log n)
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] > target) 
                right = mid - 1;
            else
                left = mid + 1;
        }
        int row = right;
        if (row < 0 || row >= matrix.length)
            return false;
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
