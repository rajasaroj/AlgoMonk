package algomonk.geekforgeek.dynamicProgramming;

public class LongestCommonSubsequnceRecusionBruteForce {

    public static void main(String[] args) {
        String a = "bd-";
        String b = "abcd-";

        int s = lcs(0,0, a.toCharArray(), b.toCharArray());
        System.out.println(s);
    }

    public static int lcs(int i, int j, char[] a, char[] b) {

        if (a[i] == '-' || b[j] == '-') return 0;


        if (a[i] == b[j]) {
            return 1 + lcs(i+1, j+1, a, b);
        } else {
            return Math.max(lcs(i+1, j, a,b), lcs(i, j+1, a,b));
        }
    }
}
