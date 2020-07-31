package base;

public class No167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target)
                break;
            else if (sum > target)
                right--;
            else
                left++;
        }
        return new int[]{left+1, right+1};
    }
}
