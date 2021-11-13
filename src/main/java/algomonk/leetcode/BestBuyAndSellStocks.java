package algomonk.leetcode;

/**
 *
 * 22 Best time to buy and Sell stock
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
 */
public class BestBuyAndSellStocks {
    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        //System.out.println(maxProfit(a));
        //maxProfit2(a);

        int[] b = {1, 9, 7, 2, 5, 3, 6, 4};
        //System.out.println(maxProfit(b));
        //maxProfit2(b);

        int[] c = {3,2,6,5,0,3};
        //System.out.println(maxProfit(c));
        maxProfit2(c);


        int[] d = {10, 7, 2, 5, 3, 6, 4, 1, 9};
        //maxProfit2(d);

        int[] e = {2,1,2,0,1};
        //maxProfit2(e);

    }

    public static void maxProfit2(int[] prices) {

        int min=Integer.MAX_VALUE,profit=0;
        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < min) {
                min = prices[i];
            }

            profit = Math.max(profit, prices[i]-min);
        }

        System.out.println(profit);
    }


    // Adhoc Solution [LIMIT TIME OUT]
    public static int maxProfit(int[] prices) {

        int max = -1;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] < prices[j] && max < (prices[j] - prices[i])) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

}

