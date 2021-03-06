package base;

public class No240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        int i = m-1, j = 0;
        while (i >= 0 && j < n){
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                i--;
            else if (matrix[i][j] < target)
                j++;
        }
        return false;
    }
}
