package base;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;

public class No990 {

    private class unionFind {
        int count = 26;
        int[] parent = new int[26];
        int[] size = new int[26];

        public unionFind() {
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(char A, char B) {
            int rootA = find(A);
            int rootB = find(B);
            if (rootA == rootB)
                return;
            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = parent[rootA];
                size[rootA] += size[rootB];
            }
            count--;
        }

        private int find(char A) {
            int i = A - 'a';
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public boolean connected(char A, char B) {
            int rootA = find(A);
            int rootB = find(B);
            return rootA == rootB;
        }
    }

    public boolean equationsPossible(String[] equations) {
        unionFind UF = new unionFind();
        for (String str : equations) {
            if (str.charAt(1) == '=')
                UF.union(str.charAt(0), str.charAt(3));
        }

        for (String str : equations) {
            if (str.charAt(1) == '!' && UF.connected(str.charAt(0), str.charAt(3)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        No990 t = new No990();
        String[] arr = {"c==c","b==d","x!=z"};
        System.out.println(t.equationsPossible(arr));
    }
}
