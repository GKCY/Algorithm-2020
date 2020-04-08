public class No10d01 {
    public void merge(int[] A, int m, int[] B, int n) {
        int pointerA = m - 1, pointerB = n-1;
        int p = A.length - 1;
        while (pointerA >= 0 && pointerB >= 0) {
            if (A[pointerA] <= B[pointerB]){
                A[p] = B[pointerB];
                pointerB--;
            } else {
                A[p] = A[pointerA];
                pointerA--;
            }
            p--;
        }
        if (pointerA < 0)
            while (pointerB >= 0){
                A[p] = B[pointerB];
                p--;
                pointerB--;
            }


    }
}
