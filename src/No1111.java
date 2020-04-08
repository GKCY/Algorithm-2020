public class No1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        char[] arr = seq.toCharArray();
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (arr[i] == '(')
                res[i] = ++depth % 2;
            else
                res[i] = depth-- % 2;
        }
        return res;
    }
}
