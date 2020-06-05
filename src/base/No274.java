package base;

public class No274 {
    public int hIndex1(int[] citations) {
        int l = 0, r = citations.length + 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (valid(mid, citations))
                l = mid + 1;
            else
                r = mid;
        }

        return l == 0 ? 0 : l - 1;
    }

    public boolean valid(int h, int[] citations) {
        int count = 0;
        for (int citation :
                citations) {
            if (citation >= h)
                count++;
        }
        return count >= h;
    }

    public int hIndex(int[] citations) {
        int[] bucket = new int[citations.length + 1];
        for (int citation:
             citations) {
            if (citation >= citations.length)
                bucket[citations.length]++;
            else
                bucket[citation]++;
        }

        int count = 0;
        for (int i = citations.length; i >= 0; i--) {
            count += bucket[i];
            if (count >= i)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new No274().hIndex(nums));
    }
}
