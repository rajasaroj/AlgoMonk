package algomonk.geekforgeek;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8};
        reverseArray(arr);
    }

    public static int[] reverseArray(int[] arr) {

        int mid = arr.length/2;
        for (int i = 0; i < mid; i++) {
            swap(arr, i, arr.length-i-1);
        }

        System.out.println(Arrays.toString(arr));
        return null;
    }

    public static void swap(int[] arr, int firstIdx, int secondIdx) {
        arr[firstIdx] = arr[firstIdx] + arr[secondIdx];
        arr[secondIdx] = arr[firstIdx] - arr[secondIdx];
        arr[firstIdx] = arr[firstIdx] - arr[secondIdx];
    }
}
