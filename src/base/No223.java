package base;

public class No223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int square = (C - A) * (D -B) + (G - E) * (H - F);
        if (E >= C || B >= H || A >= G || D <= F)
            return square;
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int overlap = (top - bottom) * (right - left);
        return square - overlap;

    }

    public static void main(String[] args) {
        System.out.println(new No223().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
