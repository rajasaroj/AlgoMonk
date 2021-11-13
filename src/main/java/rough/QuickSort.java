package rough;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
         int a[] = {3,1,2,7,6,9,0};
        //int a [] = {10, 16, 8, 12, 15, 6, 3, 9, 5};
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a, int l, int h) {

        if (l < h) {
            int pivot = partition(a, l , h);

            sort(a, l, pivot);
            sort(a, pivot+1, h);
        }
    }

    public static int partition(int[] a, int l, int h) {

        int pivot = a[l];
        int low = l;
        int high = h;

        while (true) {
            while ( a[low] > pivot) {low++;}
            while (a[high] < pivot) {high--;}

            if (low < high) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                low++;
                high--;
            } else {
                return high;
            }
        }
    }
}
