package rough;

public class KnapSacker {


    public static void main(String[] args) {
        int N = 4;
        int W = 8;
        int values[] = {1,2,5,6};
        int weight[] = {2,3,4,5};

        int[][] dp = new int[N+1][W+1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {

                if (i==0 || j==0) {
                    dp[i][j] = 0;
                } else if (j - weight[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    int res = j - weight[i-1];

                    if (res == 0) {
                        dp[i][j] = Math.max(values[i-1], dp[i-1][j]);

                    } else {
                        dp[i][j] = Math.max(values[i - 1] + dp[i-1][res], dp[i - 1][j]);
                    }

                }

            }
        }

        System.out.println();
    }
}
