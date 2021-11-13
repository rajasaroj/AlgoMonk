package algomonk.sorts;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] b = {0,1,2,3,4,5,6,7,8};
       // Integer[] a = {9,3,4,2,5,6,7,8,1};
        Integer[] a = {-100, 100, 2, 3};

        mergesort(a, 0, a.length - 1, "L");
        System.out.println(Arrays.toString(a));
    }

    public static Integer[] mergesort(Integer[] a, int l, int r, String val) {

        System.out.println("l: "+ l + " r: "+ r + " from: "+ val);
        if (l < r) {

            int mid = (r+l)/2;

            mergesort(a, l, mid, "L");
            mergesort(a, mid+1, r, "R");

            merge(a, l , mid, r);
        }
        return a;
    }

    public static Integer[] merge(Integer[] a, int l, int mid, int r) {


        Integer[] left = Arrays.copyOfRange(a, l, mid+1); //new Integer[n1];
        Integer[] right = Arrays.copyOfRange(a, mid+1, r+1); //new Integer[n2];



        System.out.println("After Jack");
        Arrays.stream(left).forEach(System.out::print);
        System.out.println();
        Arrays.stream(right).forEach(System.out::print);
        System.out.println();
        System.out.println(Arrays.toString(a));
        System.out.println("------");

        int i = 0, j = 0;
        int k = l;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) { a[k++] = left[i++]; } // Switch the operator for asc/desc
            else { a[k++] = right[j++]; }
        }

        while (i < left.length) { a[k++] = left[i++]; }
        while (j < right.length) { a[k++] = right[j++]; }

        return a;
    }


}
