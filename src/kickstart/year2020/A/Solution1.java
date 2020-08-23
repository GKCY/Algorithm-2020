package kickstart.year2020.A;

import java.util.Arrays;
import java.util.Scanner;

class Solution1 {
    public int cal(int[] nums, int money) {
        int res = 0;
        Arrays.sort(nums);
        for(int num: nums) {
            if (money - num < 0)
                break;
            res++;
            money -= num;
        }
        return res;
    }

    public int answer(int[] nums, int money) {
        int[] bucket = new int[1001];
        for (int num : nums)
            bucket[num]++;
        int res = 0;
        for (int i = 1; i <= 1000; i++) {
            while (bucket[i] > 0 && money >= i) {
                res++;
                bucket[i]--;
                money -= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();
        Solution1 solution = new Solution1();
        for (int i = 1; i <= loop; i++) {
            int size = scanner.nextInt();
            int money = scanner.nextInt();
            int[] nums = new int[size];
            for (int j = 0; j < size; j++) {
                nums[j] = scanner.nextInt();
            }
            int res = solution.answer(nums, money);
            System.out.println("Case #"+ i +":" + res);
        }
    }
}