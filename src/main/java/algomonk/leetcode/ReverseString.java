package algomonk.leetcode;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[] {'h','e','l','l','o'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        int mid = s.length/2;
        for (int i = 0; i < mid; i++) {
            swap(s, i, s.length - i - 1);
        }


        System.out.println(Arrays.toString(s));
    }

    public static void swap(char[] arr, int firstIdx, int secondIdx) {
        arr[firstIdx] = (char) (arr[firstIdx] + arr[secondIdx]);
        arr[secondIdx] = (char) (arr[firstIdx] - arr[secondIdx]);
        arr[firstIdx] = (char) (arr[firstIdx] - arr[secondIdx]);

    }
}
