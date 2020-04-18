package competition;

import tool.Tools;

import java.util.Arrays;

public class LCP08 {
    //todo
    //暴力解法超时了，等有好的题解出来了修改。
    public static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] res = new int[requirements.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < requirements.length; i++) {
            int[] requirement = requirements[i];
            int C = 0, R = 0, H = 0, time = 0;
            for (int[] add :
                    increase) {
                if (C >= requirement[0] && R >= requirement[1] && H >= requirement[2]
                        && res[i] == -1){
                    res[i] = time;
                    break;
                }
                time++;
                C += add[0];
                R += add[1];
                H += add[2];
            }
            if (C >= requirement[0] && R >= requirement[1] && H >= requirement[2]
                    && res[i] == -1){
                res[i] = time;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] increase = {{0,4,5},{4,8,8},{8,6,1},{10,10,0}};
        int[][] requirements = {{20,2,6},{9,2,6},{10,18,3},{8,14,9}};
        Tools.printArrays(LCP08.getTriggerTime(increase, requirements));
    }
}
