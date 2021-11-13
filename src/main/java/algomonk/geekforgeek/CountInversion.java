package algomonk.geekforgeek;

import java.util.Arrays;

/**
 *
 * 21 Count Inversion
 *
 *
 * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 */
public class CountInversion {



    public static void main(String[] args) {

        long ctr=0;
        long a[] = {0,2,3,4,0,1,1,1};
        //long a[] = {1,20,6,7,5,8,11,3};

        ctr = sort(a, 0, a.length-1, ctr);
        System.out.println(Arrays.toString(a));
        System.out.println(ctr);

    }

    /**
     *
     * i     m
     * 2,4   1,3,5
     *
     * 2-0 = 2
     *
     *   i      j
     * 0,2,3,4  0,1,1,1
     *
     * inversion sets
     * j=0 element = 0
     * (2,0)
     * (3,0)
     * (4,0)
     *
     * j=1 element = 1
     * (2,1)
     * (3,1)
     * (4,1)
     *
     * j=2 element = 1
     * (2,1)
     * (3,1)
     * (4,1)
     *
     * j=3 element = 1
     * (2,1)
     * (3,1)
     * (4,1)
     *
     * Total inversion = 12
     *
     * left.length - i = ans
     * 4-1 = 3
     * 4-1 = 3
     * 4-1 = 3
     * 4-1 = 3
     *
     * @param a
     * @param l
     * @param h
     */
    public static long sort(long a[], int l, int h, long ctr) {

        if (l < h) {
            int m = (l + h) / 2;
            ctr = sort(a, l, m, ctr);
            ctr = sort(a, m+1, h, ctr);
            ctr = mergeSort(a, h, l, m, ctr);

        }
        return ctr;
    }

    public static long mergeSort(long a[], int h, int l, int m, long ctr) {

        long[] left = Arrays.copyOfRange(a, l, m+1);
        long[] right = Arrays.copyOfRange(a, m+1, h+1);

        int i=0,j=0,k=l;

        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                ctr += (left.length-i);
                a[k++] = right[j++];
            }
        }

        while (i < left.length) {
            a[k++] = left[i++];
        }

        while (j < right.length) {
            a[k++] = right[j++];
        }

        return ctr;
    }

}
