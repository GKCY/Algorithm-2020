package base;

public class No134 {
    //暴力模拟
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        for (int i = 0; i < gas.length; i++) {
//            if (tracking(gas, cost, i))
//                return i;
//        }
//        return -1;
//    }
//
//    public boolean tracking(int[] gas, int[] cost, int position) {
//        int gasAmount = 0;
//        for (int i = 0; i < gas.length; i++) {
//            gasAmount += gas[position];
//            if (gasAmount < cost[position])
//                return false;
//            gasAmount -= cost[position];
//            position = (position + 1) % gas.length;
//        }
//        return true;
//    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int cur = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
