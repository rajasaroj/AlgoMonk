package algomonk.sorts;

import java.util.Arrays;

// This sort runs in descending order...
public class LetsQuickSortDesc {

    public static int n;
    public static void main(String[] args) {
        //int[] at = {10, 16, 8, 12, 15, 6, 3, 9, 5};
        int[] at = {10, 6, 5};
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

        int pivot = a[low];
        int i = low;
        int j = high;

        while (i < j) {
            while ( a[i]  >= pivot) {
                i++;
                if (i == n) {break;}  // NOTE: Its important to break at the length of array to avoid array exception
            }
            while ( a[j] < pivot) { j--; }
            if (i < j) swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    public static void swap(int a[], int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }


}
