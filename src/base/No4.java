package base;

public class No4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if ((len & 1) == 1)
            return findKthSmallest(nums1, 0, nums2, 0, len/2+1) * 1.0;
        else
            return (findKthSmallest(nums1, 0, nums2, 0, len/2+1)
                + findKthSmallest(nums1, 0, nums2, 0, len/2)) / 2.0;
    }

    public double findKthSmallest(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length)
            return nums2[start2 + k - 1];
        if (start2 >= nums2.length)
            return nums1[start1 + k - 1];
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);
        int mid1 = start1 + k / 2 - 1;
        int mid2 = start2 + k / 2 - 1;
        if (mid1 >= nums1.length)
            mid1 = nums1.length - 1;
        if (mid2 >= nums2.length)
            mid2 = nums2.length - 1;

        if (nums1[mid1] <= nums2[mid2])
            return findKthSmallest(nums1, mid1 + 1, nums2, start2, k - (mid1 - start1 + 1));
        else
            return findKthSmallest(nums1, start1, nums2, mid2 + 1, k - (mid2 - start2 + 1));
    }

    public static void main(String[] args) {
        int[] nums1 = {3};
        int[] nums2 = {1, 2};
        double res = new No4().findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
