package base;

public class No74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            int midValue = matrix[mid/n][mid%n];
            if (midValue == target)
                return true;
            else if (midValue > target)
                right = mid - 1;
            else if (midValue < target)
                left = mid + 1;
        }
        return false;
    }
}
