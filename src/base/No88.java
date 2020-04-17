package base;

public class No88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        for (int i = 0; i < m + n; i++) {
            if (p1 < 0) {
                nums1[tail] = nums2[p2];
                p2--;
                tail--;
            } else if (p2 < 0) {
                break;
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[tail] = nums1[p1];
                p1--;
                tail--;
            } else if (nums1[p1] < nums2[p2]) {
                nums1[tail] = nums2[p2];
                p2--;
                tail--;
            }
        }
    }
}
