package algomonk.leetcode;

import java.util.Arrays;

// This sort runs in descending order...
public class LetsQuickSortDesc {

    public static int n;
    public static void main(String[] args) {
        int[] at = {10, 16, 8, 12, 15, 6, 3, 9, 5};
        //int[] at = {10, 6, 5};
        n = at.length;
        qsort(at, 0, at.length-1);
        System.out.println(Arrays.toString(at));
    }

    public static void qsort(int a[],int low, int high) {

        if (low < high) {
            int pivot = partition(a, low, high);
            qsort(a, low, pivot);
            qsort(a, pivot + 1, high );
        }
    }

    public static int partition(int a[], int low, int high) {

        int pivot = a[low]; // the objective of having pivot is to have all the element smaller to it on left and greater on the right at the end of partition
        int i = low; // increment i until you find element greater than pivot
        int j = high; // decrement j until you find element smaller and equal to pivot

        while (true) {

            while ( a[i]  > pivot) {i++;}  // switch the operator for asc/desc
            while ( a[j] < pivot) { j--; } // switch the operator for asc/desc

            if (i < j) {
                swap(a, i, j);
                i++;
                j--;
            } else {
                return j;
            }
        }
    }

    public static void swap(int a[], int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }


}
