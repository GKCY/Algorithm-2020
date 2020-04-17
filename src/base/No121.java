package base;

public class No121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int minNum = prices[0];
        int maxRes = 0;
        for (int price :
                prices) {
            if (price < minNum)
                minNum = price;
            if (price - minNum > maxRes)
                maxRes = price - minNum;
        }
        return maxRes;
    }
}
