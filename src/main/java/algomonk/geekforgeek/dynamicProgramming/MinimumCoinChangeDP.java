package algomonk.geekforgeek.dynamicProgramming;

public class MinimumCoinChangeDP {

    public static void main(String[] args) {
        //int[] coins = {2,1, 5, 10};
        int[] coins = {5, 2, 3};



        int amount = 6;
        System.out.println(change(coins, amount));

    }

    /**
     * Boundary Cases:
     * if the amount is 0 then the min number of coins required is zero
     * if the amount is > 0 and the current number of coins is zero then minimum number of coins require to sum up that amount will be infinte
     * for eg amt=1 current number of coins is zero that mean you need to add 0 + 0 + 0 + 0 ...... infinite times to get total amount as 1
     *
     * Create Matrix table of amount vs numberOfCoins
     * where i = number of coins
     *       j = amount
     *
     * cell dp[i][j] = says if we give you unlimited instances of (i) number of coin,
     * then what will be the minimum number of coins required to form amount (j)
     *
     *
     * consider: inclusion and exclusion case
     * --------------------------------------
     * exclusion = dp[i-1][j]
     * breakdown explanation: this give minimum number of coin if you exclude the current denomination
     * this value will be useful when the current denomination is Greater than the amount itself
     * for eg: you're current denomination is 5 and amount is 2, you will never able to make amount=2 from 5 rupees coin, in that case you have to exclude.
     *
     *
     * inclusion = 1 + dp[i][j - coins[i-1]]
     * breakdown explanation: this gives minimum number of coin if you include the current denomination
     * here the formula says
     * 1 + dp [number of coins] [amount - coins[index of current denomination coin from coins array] ]
     *
     * lets take eg: coins[1, 2, 5] = 2
     * dp[1][2] = the question here is, if we give you unlimited instances of (i=1) number of coin, how many coins it will take to make total amount j=2
     * here you see its not possible to form amount j=2 using single 1 rupee coin.
     * hence with the magic of Dynamic programming this problem will break down into sub problem (follow the calculation below)
     *
     * dp[1][2] = 1 + dp[1][2 - coins[1-1]]
     *            1 + dp[1][2-1]             // Coin at zeroth index in coins array is 1 rupees coin
     *            1 + dp[1][1]               // Here the sub problem is dp[1][1], and if you fill the matrix table from beginning then you must have all filled the minimum coins for dp[1][1]
     *            1 + 1
     *            = 2
     *
     * hence the minimum number of coins to form amount j=2 using 1 rupees coins = 2
     *
     *
     *
     * @return
     */
    public static int change(int[] coins, int amount) {

        double[][] dp = new double[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {

                if (j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = 1e7;
                } else if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]], dp[i-1][j]);
                }
            }
        }

        return (int)(dp[coins.length][amount] >= 1e7 ? -1 : dp[coins.length][amount]);
    }
}
