package algomonk.geekforgeek.dynamicProgramming;

public class LongestCommonSubsequnceMemoization {

    public static void main(String[] args) {
        String a = "bd-";
        String b = "abcd-";
        int[][] dp = new int[a.length()-1][b.length()-1];
        int s = lcs(0,0,a.toCharArray(),b.toCharArray(),dp);
        System.out.println(s);
    }

    public static int lcs(int i, int j, char[] a, char[] b, int[][] dp) {

        if (a[i] == '-' || b[j] == '-') return 0;

        if (a[i] == b[j]) {
            if (dp[i][j] == 0) {
                dp[i][j] = 1 + lcs(i+1, j+1, a,b, dp);
            }
        } else {
            dp[i][j] = Math.max(lcs(i+1, j, a,b,dp), lcs(i, j+1, a,b,dp));
        }

        return dp[i][j];
    }

}
