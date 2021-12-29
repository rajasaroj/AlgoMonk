package rough;

public class MaxCoinChange {
    public static void main(String[] args) {

        int k = 4;
        int[] coins = {1,2,3};
        int[][] dp = new int[coins.length+1][k+1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <=k ; j++) {

                if (j == 0) {
                    dp[i][j] =1;
                } else if (i==0) {
                    dp[i][j] = 0;
                } else if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = (dp[i][j - coins[i-1]]) + dp[i-1][j];
                }

            }
        }

        System.out.println();

    }
}
