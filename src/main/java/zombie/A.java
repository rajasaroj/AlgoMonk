package zombie;

import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
public class A {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 0, 1, 2};
        solution_two(a);
    }

    /**
     *
     * Complexity = O(n)
     * The Algorithm maintains three pointers:
     * l = responsible for giving the references (index) of elements at the starting of the array.
     * m = reposible for traversing accross the array from l to h, and uses l and h as reference pointer to swap 0 and 2 (doesn't nothing when values is 1)
     * h = responsible for giving the references (index) of elements at the ending of the array.
     *
     *
     * the below algorithm checks if value at mth index == 0 it will replace it with l and move m and l. (because zero's are supposedly accumulated at starting of array the region who's references handled by pointer l)
     * and check if mth index==2 it will replace it with h and ONLY MOVES --high (because two's are supposedly accumulated at ending of array the region who's references handled by pointer h)
     *
     * @param a
     */
    public static void solution_two(int a[]) {
        int l = 0;
        int m =0;
        int h = a.length-1;

        while (h >= m) {

            if (a[m] == 0) {
                swap(a, l, m);
                l++;
                m++;
            } else if (a[m] == 1) {
                m++;
            } else {
                swap(a, m, h);
                h--;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void swap(int a[], int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    /**
     * Complexity = 2n
     * @param a
     */
    public static void solution_one(int a[]) {
        int zeroCount =0;
        int oneCount =0;
        int twoCount =0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] == 0) {
                zeroCount++;
            } else if (a[i] == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }

        IntStream.range(0,zeroCount).forEach(i -> a[i] =0);
        IntStream.range(zeroCount,zeroCount + oneCount).forEach(i -> a[i] =1);
        IntStream.range(zeroCount + oneCount, zeroCount + oneCount + twoCount).forEach(i -> a[i] =2);

        System.out.println(Arrays.toString(a));
    }
}
