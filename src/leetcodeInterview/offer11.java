package leetcodeInterview;

public class offer11 {
    public int minArray1(int[] numbers) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (numbers[mid] == numbers[l] && numbers[mid] == numbers[r])
                l++;
            else if (numbers[mid] <= numbers[r])
                r = mid;
            else if (numbers[mid] > numbers[r])
                l = mid + 1;
        }
        return numbers[l];
    }

    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (numbers[mid] < numbers[r])
                r = mid;
            else if (numbers[mid] > numbers[r])
                l = mid + 1;
            else
                r--;
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,1};
        System.out.println(new offer11().minArray(nums));
    }
}
