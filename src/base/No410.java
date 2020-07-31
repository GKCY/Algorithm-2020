package base;

public class No410 {
    public int splitArray(int[] nums, int m) {
        long l = 0, h = 0;
        for (int num : nums) {
            if (num > l)
                l = num;
            h += num;
        }

        while (l < h) {
            long mid = (l + h) / 2;
            long sum = 0, cnt = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    cnt++;
                    sum = num;
                } else {
                    sum  += num;
                }
            }
            if (cnt > m)
                l = mid + 1;
            else
                h = mid;
        }
        return (int)l;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(new No410().splitArray(nums, m));
    }
}
