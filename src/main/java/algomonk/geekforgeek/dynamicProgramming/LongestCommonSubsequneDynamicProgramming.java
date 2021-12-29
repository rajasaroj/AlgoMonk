package algomonk.geekforgeek.dynamicProgramming;

public class LongestCommonSubsequneDynamicProgramming {

    public static void main(String[] args) {
        String a = "bd";
        String b = "abcd";
        int[][] dp = new int[a.length()+1][b.length()+1];
        int s = lcs_using_dp(dp, a.toCharArray(), b.toCharArray());
        System.out.println(s);
    }

    public static int lcs_using_dp(int[][] dp, char[] a, char[] b) {

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length ; j++) {

                if (i==0 || j==0) {
                    continue;
                } else if (a[i-1] == b[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[a.length][b.length];
    }



}
