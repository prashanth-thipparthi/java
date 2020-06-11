package DynamicProgramming;

public class BuySellStock {
    // public int maxProfit(int[] prices) {
    //     int len = prices.length;
        
    //     int minBuyPrice = Integer.MAX_VALUE;
    //     int maxProfit = 0;
    //     for(int i=0; i<len; i++) {
    //         if(prices[i] < minBuyPrice) {
    //             minBuyPrice = prices[i];
    //         } else{
    //             maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
    //         }
    //     }
    //     return maxProfit;
    // }

    public int check(int i) {
        if(i ==5) {
            return i;
        }
        return i+check(i+1);
    }

    public static void main(String args[]) {
        BuySellStock bs = new BuySellStock();
        System.out.println(bs.check(0));
    }
}