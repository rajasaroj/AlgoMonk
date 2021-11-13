package rough;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int a[] = {3,1,2,7,6,9,0};
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));

    }

    public static void sort(int[] a, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            sort(a, l, m);
            sort(a, m+1, h);

            merge(a, l, h, m);
        }
    }

    public static void merge(int[] a, int l, int h, int m) {
        int[] left = Arrays.copyOfRange(a, l, m+1);
        int[] right = Arrays.copyOfRange(a, m+1, h+1);

        int i=0, j=0, k=l;
        while ( i < left.length && j < right.length) {

            if (left[i] < right[j] ) // Switch the operator for asc/desc
                a[k++] = left[i++];
             else
                a[k++] = right[j++];

        }

        while (i < left.length) { a[k++] = left[i++]; }

        while (j < right.length) { a[k++] = right[j++]; }
    }
}
