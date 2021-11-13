package algomonk.geekforgeek;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
public class RotateByN {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        rotate(a, 3);
        System.out.println(Arrays.toString(a));
    }

    public static void rotate(int arr[], int n) {
        if (n > 0) for (int i = 0; i < n; i++) { rotateArray(arr); }
    }

    public static void rotateArray(int arr[]) {
        int n = arr[arr.length-1];
        for (int i = arr.length-1; i>0 ; i--) { arr[i] = arr[i-1]; }
        arr[0] = n;
    }


}