package competition;

public class No5468 {
    public int findKthPositive(int[] arr, int k) {
        int[] bucket = new int[2001];
        for (int num : arr) {
            bucket[num]++;
        }

        int i = 1, idx = 0, res = 0;
        while (idx < k && i < 2001) {
            if (bucket[i] == 0) {
                idx++;
                res = i;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 2;
        System.out.println(new No5468().findKthPositive(nums, k));
    }
}
