package algomonk.recursion;
import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/submissions/
public class Stairways {

    public static void main(String[] args) {
        Integer[] r = new Integer[45];
        System.out.println(numWays(5, r));
        System.out.println(Arrays.toString(r));
    }

    public static int numWays(int n, Integer[] r) {
        if (n <= 0 || n == 1) return 1;
        if (n == 2) return 2;

        if (r[n-1] != null) {
            return r[n - 1];
        }

        int val =  numWays(n - 1, r) + numWays(n-2, r);
        r[n-1] = val;
        return val;
    }
}