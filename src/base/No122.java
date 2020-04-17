package base;

public class No122 {
    public int maxProfit(int[] prices) {
        int i = 0;
        int length = prices.length;
        int low =prices[0], high = prices[0], sum=0;
        while (i < length-1) {
            while (i < length - 1 && prices[i] >= prices[i+1])
                i++;
            low = prices[i];
            while (i < length - 1 && prices[i] <= prices[i+1])
                i++;
            high = prices[i];
            sum += high - low;
        }
        return sum;
    }
}
