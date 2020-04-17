package base;

public class No945 {
    public int solution1(int[] A) {
        int[] nums = new int[80000];
        for (int a :
                A) {
            nums[a]++;
        }
        int count=0, res = 0;
        for (int i = 0; i < 80000; i++) {
            if (nums[i] > 1) {
                res -= (nums[i]-1)*i;
                count += nums[i]-1;
            }
            if (count > 0 && nums[i] == 0) {
                count--;
                res += i;
            }
        }
        return res;
    }
}
