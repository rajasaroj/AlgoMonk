package algomonk.geekforgeek;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfArrays {


    public static void main(String[] args) {
        int[] a = {85, 25, 1, 32, 54, 6};
        int[] b = {85,2};

        System.out.println(doUnion(a, a.length, b, b.length));
    }

    public static int doUnion(int a[], int n, int b[], int m)
    {

        Set<Integer> at = new HashSet<>();
        for (int i = 0; i < n; i++) {
            at.add(a[i]);
        }

        for (int i = 0; i < m; i++) {
            at.add(b[i]);
        }

        return at.size();
    }


}
