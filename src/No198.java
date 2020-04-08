public class No198 {
    public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;
        for (int num :
                nums) {
            int temp = Integer.max(pre + num, cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }

}
