package base;

import tool.Utils;

import java.util.Arrays;

public class No684 {
    class UF {
        int[] parent;
        int[] size;

        public UF(int N) {
            this.parent = new int[N];
            this.size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p , int q) {
            p = find(p);
            q = find(q);
            if (p == q)
                return;
            if (size[p] < size[q]) {
                parent[p] = q;
                size[q] += size[p];
            } else {
                parent[q] = p;
                size[p] += size[q];
            }
        }

        public boolean connect(int p, int q) {
            return p == q || find(p) == find(q);
        }


    }


    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[] res = new int[2];
        UF uf = new UF(N+1);
        for (int[] edge : edges) {
            if (uf.connect(edge[0], edge[1])) {
                res[0] = edge[0];
                res[1] = edge[1];
            } else {
                uf.union(edge[0], edge[1]);
            }
        }
        Utils.printArrays(uf.parent);
        return res;
    }

    public static void main(String[] args) {
        int[][] edges ={{1,2},{2,3},{3,4},{1,4},{1,5}};
        Utils.printArrays(new No684().findRedundantConnection(edges));
    }
}
