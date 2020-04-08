public class No11 {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1;
        int max=0,cur;
        while (i != j){
            cur = (j-i)*Integer.min(i, j);
            if (cur > max)
                max = cur;
            if (i < j)
                i++;
            else
                j--;
        }
        return max;
    }
}
