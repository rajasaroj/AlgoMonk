package rough;

public class MinimumCoins {
    public static void main(String[] args) {

        int k = 6;
        int[] coins = {1,2,5};

        int[][] dp = new int[coins.length + 1][k+1];


        for (int i = 0; i <= coins.length; i++) {

            for (int j = 0; j <= k; j++) {

                if (i==0 && j==0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else if (coins[i-1] > j)  {
                    dp[i][j] = dp[i-1][j];
                } else {
                    System.out.println();
                    dp[i][j] = Math.min( (1 + dp[i][j - coins[i-1]]) , dp[i-1][j]);
                }
            }
        }

        System.out.println();
    }
}
