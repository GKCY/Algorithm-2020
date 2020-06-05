package leetcodeInterview;

import java.util.ArrayList;

public class Mianshi57II {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 0;
        ArrayList<int[]> temp = new ArrayList<>();
        while (left <= target/2+1) {
            if (sum < target){
                right++;
                sum += right-1;
            } else if (sum < target) {
                sum -= left;
                left++;
            } else if (sum == target){
                temp.add(createArr(left, right-1));
                sum -= left;
                left++;
            }
        }
        return temp.toArray(new int[temp.size()][]);
    }

    public int[] createArr(int left, int right){
        int length = right-left+1;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = left;
            left++;
        }
        return arr;
    }
}
