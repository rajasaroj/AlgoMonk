package algomonk.geekforgeek;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
public class KthSmallest {
    public static void main(String[] args) {
        int[] a = new int[] {0, -1, 1, 2, -2, 3, 4, 5, 6, 7, 8, -9}; //7 10 4 3 20 15   => 3 4 7 10 15 20
        // int[] a = new int[] {7,10, 4, 3, 20, 15};
        // int[] a = new int[] {7,10, 17};
        int v = kthSmallest(a, 0, a.length-1, 3);
        System.out.println(v);
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        mergeSort(arr, l,r);
        return arr[k-1];
    }

    public static void mergeSort(int arr[], int l, int r) {
       if (l < r) {
           int mid = (l+r)/2;

           mergeSort(arr, l, mid);
           mergeSort(arr, mid+1, r);

           merge(arr, l, mid, r);
       }
    }

    public static void merge(int arr[], int l, int mid, int r) {

        int arrleft[] = Arrays.copyOfRange(arr, l, mid+1);
        int arrRight[] = Arrays.copyOfRange(arr, mid+1, r+1);

        int i=0, j=0, k=l;

        while (i < arrleft.length && j < arrRight.length) {
            if (arrleft[i] < arrRight[j]) { arr[k++] = arrleft[i++];}
            else { arr[k++] = arrRight[j++]; }
        }

        while (i < arrleft.length) {arr[k++] = arrleft[i++];}
        while (j < arrRight.length) { arr[k++] = arrRight[j++]; }
    }


}
