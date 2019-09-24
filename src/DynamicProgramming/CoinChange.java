package DynamicProgramming;


/*
// S^n time complexity
// where 'S' is the sum, and 'n' is the number of coins.
public class CoinChange {

    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins,amount,0);
    }


    public int coinChange(int[] coins, int amount, int noOfCoins) {
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (amount == 0)
            return noOfCoins;

        for (int i = 0; i < coins.length; i++) {
            int coin = coinChange(coins, amount-coins[i],noOfCoins+1);
            min = Math.min(min,coin);
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String args[]){
        CoinChange c = new CoinChange();
        int[] coins = new int[]{2};
        System.out.println("coins:"+c.coinChange(coins,3));
    }
}
*/

/*
public class CoinChange {


    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        return coinChange(coins,amount,dp);
    }


    public int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (amount == 0)
            return 0;
        if(dp[amount-1] > 0)
            return dp[amount-1];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int coin = coinChange(coins, amount-coins[i],dp);
            if(coin < min){
                min = 1+coin;
            }
            //min = Math.min(min,coin);
        }
        dp[amount-1] = min==Integer.MAX_VALUE ? -1 : min;
        return dp[amount-1];
    }

    public static void main(String args[]){
        CoinChange c = new CoinChange();
        int[] coins = new int[]{1,2,5};
        System.out.println("coins:"+c.coinChange(coins,11));
    }
}
*/

import java.util.Arrays;

public class CoinChange {


    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        int max = amount+1;
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount] > amount ? -1:dp[amount];
    }

    public static void main(String args[]){
        CoinChange c = new CoinChange();
        int[] coins = new int[]{1,2,5};
        System.out.println("coins:"+c.coinChange(coins,11));
    }
}
