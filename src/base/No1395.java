package base;

public class No1395 {

    //枚举中间点
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 0; i < rating.length; i++) {
            int leftMin, leftMax, rightMin, rightMax;
            leftMax = leftMin = rightMin = rightMax = 0;
            for (int j = i-1; j >= 0; j--) {
                if (rating[j] > rating[i])
                    leftMax++;
                if (rating[j] < rating[i])
                    leftMin++;
            }
            for (int j = i+1; j < rating.length; j++) {
                if (rating[j] > rating[i])
                    rightMax++;
                if (rating[j] < rating[i])
                    rightMin++;
            }
            res += leftMax * rightMin + leftMin * rightMax;
        }
        return res;
    }
}
