package base;

public class No1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            res++;
            numBottles = numBottles - numExchange + 1;
        }
        return res;
    }

}
