package base;

public class No547 {
    private class UF {
        int[] size;
        int[] nums;
        int res;

        public UF(int n) {
            size = new int[n];
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i;
                size[i] = 1;
            }
            res = n;
        }

        public int find(int n) {
            while (nums[n] != n) {
                nums[n] = nums[nums[n]];
                n = nums[n];
            }
            return n;
        }

        public boolean connected(int A, int B) {
            if (A == B)
                return true;
            return find(A) == find(B);
        }

        public void union(int A, int B) {
            int aRoot = find(A);
            int bRoot = find(B);
            if (aRoot == bRoot)
                return;
            if (size[aRoot] < size[bRoot]) {
                nums[aRoot] = bRoot;
                size[bRoot] += size[aRoot];
            } else {
                nums[bRoot] = aRoot;
                size[aRoot] += size[bRoot];
            }
            res--;
        }
    }
    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.res;
    }
}
