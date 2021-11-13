package algomonk.geekforgeek;

// https://practice.geeksforgeeks.org/problems/coin-change2448/1#
public class MaximumCoinChangeDP {

    public static void main(String[] args) {
        //int[] coins = {2, 5, 3, 6};
        int[] coins = {1,2,3};

        int amount = 4;
        System.out.println(changeCount(coins, amount));

    }

    public static long changeCount(int[] coins, int amount) {

        long[][] dp = new long[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {

                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] =  dp[i][j - coins[i-1]] + dp[i-1][j];
                }

            }
        }
        return dp[coins.length][amount];
    }
}
