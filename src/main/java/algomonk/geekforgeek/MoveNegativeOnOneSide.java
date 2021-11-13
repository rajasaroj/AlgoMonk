package algomonk.geekforgeek;

import java.util.Arrays;

public class MoveNegativeOnOneSide {

    public static void main(String[] args) {
        int[] a = { -700,-1,0,-3,-12, 1,0,0,0,-200,-200};

        rearrange(a, a.length);
        System.out.println(Arrays.toString(a));

    }

    static void rearrange(int arr[], int n)
    {
        int j = 0;
        for (int i = 0; i < n; i++) {

            if(arr[i] < 0) {
                if (i > j) {
                    swap(arr, i,j);
                }
                j++;
            }

        }
    }

    public static void swap(int[] a, int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
}
