package algomonk.sorts;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] at = {10, 16, 8, 12, 15, 6, 3, 9, 5};

        qsort(at, 0, at.length-1); // NOTE: ITS IMPORTANT TO PROVIDE FULL LENGTH OF ARRAY AS HIGH SO THAT ALGO CAN CONSIDER LAST ELEMENT AT LINE NO 33 J--
        System.out.println(Arrays.toString(at));
    }

    public static void qsort(Integer[] a, int i, int j) {

        if(i < j) {
            int pivot_index = partition(a, i, j);
            qsort(a, i, pivot_index);
            qsort(a, pivot_index + 1, j);
        }

    }

    public static int partition(Integer[] a, int l, int h) {

        int pivot = a[l]; // the objective of having pivot is to have all the element smaller to it on left and greater on the right at the end of partition
        int i = l; // increment i until you find element greater than pivot
        int j = h; // decrement j until you find element smaller and equal to pivot

        while (true) {

            while ( a[i]  < pivot) {i++;}  // switch the operator for asc/desc
            while ( a[j] > pivot) { j--; } // switch the operator for asc/desc

            if (i < j) {
                swap(a, i, j);
                i++;
                j--;
            } else {
                return j;
            }
        }
    }

    public static void swap(Integer[] a, int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
}
