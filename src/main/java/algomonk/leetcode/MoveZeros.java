package algomonk.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/submissions/
public class MoveZeros {
    public static int count = 0;
    public static int countj = 0;
    public static void main(String[] args) {
        int[] a = { 0,0,0,4,12, 1,0,0,0,1,0};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
        System.out.println(count+countj);
    }

    public static void moveZeroes(int[] a) {

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (a[j-1] == 0 && a[j] != 0) { swap(a, j-1, j); }
                else { break;}
            }
        }
    }

    public static void swap(int[] a, int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
}
