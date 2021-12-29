package algomonk.geekforgeek.dynamicProgramming;

/**
 *
 * 411 Knapsack Problem
 * https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 */
public class KnapSackZeroOrOne {

    public static void main(String[] args) {
//        int N = 58;
//        int W = 41;
//        int values[] = {57,95,13,29,1 ,99,34,77,61,23,24,70 ,73,88,33,61,43,5 ,41,63,8 ,67,20,72,98,59,46,58,64,94,97,70,46,81,42,7,1,52,20,54,81,3,73,78,81,11,41,45,18,94,24,82,9,19,59,48,2,72};
//        int weight[] = {83,84,85,76,13,87,2 ,23,33,82,79,100,88,85,91,78,83,44,4 ,50,11,68,90,88,73,83,46,16,7 ,35,76,31,40,49,65,2,18,47,55,38,75,58,86,77,96,94,82,92,10,86,54,49,65,44,77,22,81,52};


//        int N = 4;
//        int W = 5;
//        int values[] = {57,1,99,34};
//        int weight[] = {83,3,87,1};




//        int N = 4;
//        int W = 8;
//        int values[] = {6,1,2,5};
//        int weight[] = {5,2,3,4};

//        int N = 4;
//        int W = 8;
//        int values[] = {1,2,5,6};
//        int weight[] = {2,3,4,5};

//        int N = 4;
//        int W = 5;
//        int values[] = {1,2,8,6};
//        int weight[] = {2,3,3,5};

        int N = 4;
        int W = 5;
        int values[] = {1,2,5,6};
        int weight[] = {2,3,4,5};

        int[][] dp = new int[N+1][W+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i==0 || j==0) {
                    dp[i][j] = 0;
                } else if (j-weight[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {

                    int res = j-weight[i-1];

                    if (res == 0) {
                        dp[i][j] =Math.max(values[i-1], dp[i-1][j]);
                    } else {


                        /**
                         * Formula breakdown for : values[i-1] + dp[i-1][res]
                         * values[i-1] says, include current object and take the current profit
                         * for remaining weight present in "res" = DO NOT included the current element which is represent by dp[i] in dp table, instead exclude the current element by using dp[i-1]
                         * hence we use formula :  dp[i-1][res], so with this, we take the profit from remaining weight "res" by excluding current element.
                         * and then we add it with current profit, hence the formula becomes values[i-1] + dp[i-1][res]
                         *
                         * There's a possibility that if we EXCLUDE the current element then the previous element might be able to give us more profit for the current weight "J"
                         * then we fetch that with formula : dp[i-1][j]
                         *
                         */
                        dp[i][j] = Math.max(values[i-1] + dp[i-1][res], dp[i-1][j]);
                    }
                }

            }
        }
        int a = dp[N][W];
        System.out.println(a);
    }
}
